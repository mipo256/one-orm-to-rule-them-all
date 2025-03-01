package com.mpolivaha.sdj;

import com.mpolivaha.sdj.SpringDataJdbcTest.CurrentContext;
import com.mpolivaha.sdj.models.CommentReply;
import com.mpolivaha.sdj.models.Post;
import com.mpolivaha.sdj.models.PostComment;
import com.mpolivaha.sdj.models.PostRepository;
import com.mpolivaha.sdj.models.manytomany.Product;
import com.mpolivaha.sdj.models.manytomany.ProductCategories;
import com.mpolivaha.sdj.models.manytomany.ProductRepository;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.core.convert.DefaultDataAccessStrategy;
import org.springframework.data.jdbc.core.convert.JdbcConverter;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.support.JdbcRepositoryFactory;
import org.springframework.data.relational.core.dialect.Dialect;
import org.springframework.data.relational.core.mapping.RelationalMappingContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = CurrentContext.class)
class SpringDataJdbcTest extends AbstractIntegrationTest {

  @Configuration
  @Import(AbstractJdbcConfiguration.class)
  static class CurrentContext {

    @Bean
    public DataSource dataSource(
        @Value("${spring.datasource.url}") String url,
        @Value("${spring.datasource.username}") String username,
        @Value("${spring.datasource.password}") String password
    ) {
      return new DriverManagerDataSource(url, username, password);
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
      return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public NamedParameterJdbcOperations namedParameterJdbcOperations(DataSource dataSource) {
      return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public JdbcRepositoryFactory jdbcRepositoryFactory(
        DefaultDataAccessStrategy defaultDataAccessStrategy,
        RelationalMappingContext relationalMappingContext,
        JdbcConverter jdbcConverter,
        Dialect dialect,
        ApplicationEventPublisher applicationEventPublisher,
        NamedParameterJdbcOperations operations
    ) {
      return new JdbcRepositoryFactory(
          defaultDataAccessStrategy,
          relationalMappingContext,
          jdbcConverter,
          dialect,
          applicationEventPublisher,
          operations
      );
    }

    @Bean
    public PostRepository postRepository(JdbcRepositoryFactory jdbcRepositoryFactory) {
      return jdbcRepositoryFactory.getRepository(PostRepository.class);
    }

    @Bean
    public ProductRepository productRepository(JdbcRepositoryFactory jdbcRepositoryFactory) {
      return jdbcRepositoryFactory.getRepository(ProductRepository.class);
    }
  }

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private DataSourceTransactionManager dataSourceTransactionManager;

  @BeforeEach
  void setUp() {
    LoggerFactory.getLogger(JdbcTemplate.class).atLevel(Level.DEBUG);
  }

  @Test
  @Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, statements = """
      CREATE SCHEMA sdj;

      CREATE TABLE IF NOT EXISTS sdj.post(
        id BIGSERIAL PRIMARY KEY,
        title TEXT,
        content TEXT,
        created_at TIMESTAMP
      );

      CREATE TABLE IF NOT EXISTS sdj.post_comment(
        id BIGSERIAL PRIMARY KEY,
        comment TEXT,
        created_at TIMESTAMP,
        post_id BIGINT -- REFERENCES sdj.post(id)
      );

      CREATE TABLE IF NOT EXISTS sdj.comment_reply(
        id BIGSERIAL PRIMARY KEY,
        body TEXT,
        created_at TIMESTAMP,
        post_comment_id BIGINT -- REFERENCES sdj.post_comment(id)
      );
      """)
  @Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, statements = """
      DROP SCHEMA sdj CASCADE;
      """)
  @Transactional
  void testAggregatePersistence() {
    // when.
    Post saved = postRepository.save(
        new Post()
            .setTitle("My post!")
            .setContent("Post content")
            .setComments(
                List.of(
                    new PostComment()
                        .setComment("My comment is large!")
                        .setCommentReplies(
                            List.of(
                                new CommentReply().setBody("Really?"),
                                new CommentReply().setBody("How so?"),
                                new CommentReply().setBody("That was nuts")
                            )
                        ),
                    new PostComment()
                        .setComment("My comment is even larger!")
                        .setCommentReplies(
                            List.of(
                                new CommentReply().setBody("That fits!"),
                                new CommentReply().setBody("True"),
                                new CommentReply().setBody("No argue")
                            )
                        )
                )
            )
    );

    // then.
    Optional<Post> foundPost = postRepository.findById(saved.getId());

    Assertions.assertThat(foundPost).isPresent().hasValueSatisfying(post -> {
      Assertions.assertThat(post.getComments()).hasSize(1);
    });
  }

  @Test
  @Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, statements = """
      CREATE SCHEMA sdj;

      CREATE TABLE IF NOT EXISTS sdj.product(
        id BIGSERIAL PRIMARY KEY,
        name TEXT
      );

      CREATE TABLE IF NOT EXISTS sdj.category(
        id BIGSERIAL PRIMARY KEY,
        name TEXT
      );

      CREATE TABLE IF NOT EXISTS sdj.product_categories(
        -- id BIGSERIAL PRIMARY KEY,
        product_id BIGINT,
        category_id BIGINT
      );
      
      INSERT INTO sdj.category(id, name) VALUES(1, 'groceries');
      """)
  @Transactional
  void testManyToManyPersistence() {
    // given.
    Product product = Product.createNew(
        0L,
        "product first",
        List.of(
            new ProductCategories()
                .setProductId(AggregateReference.to(0L))
                .setCategoryId(AggregateReference.to(1L))
        )
    );

    // when.
    Product saved = productRepository.save(product);

    // then.
    Optional<Product> foundProduct = productRepository.findById(saved.getId());

    Assertions.assertThat(foundProduct).isPresent().hasValueSatisfying(it -> {
      Assertions.assertThat(it.getProductCategories())
          .hasSize(1)
          .first()
          .extracting("categoryId")
          .isEqualTo(AggregateReference.to(1L));
    });
  }
}