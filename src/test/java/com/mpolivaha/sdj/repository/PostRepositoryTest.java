package com.mpolivaha.sdj.repository;

import ch.qos.logback.classic.Logger;
import com.mpolivaha.sdj.models.CommentReply;
import com.mpolivaha.sdj.models.Post;
import com.mpolivaha.sdj.models.PostComment;
import com.mpolivaha.sdj.repository.PostRepositoryTest.CurrentContext;
import java.util.List;
import javax.sql.DataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
import org.springframework.transaction.support.TransactionTemplate;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = CurrentContext.class)
class PostRepositoryTest extends AbstractIntegrationTest {

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
  }

  @Autowired
  private PostRepository postRepository;

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
  void testAggregatePersistence() {
    new TransactionTemplate(dataSourceTransactionManager).executeWithoutResult(transactionStatus -> {
      postRepository.save(
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
    });
  }
}