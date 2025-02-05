package com.mpolivaha.hibernate;

import com.mpolivaha.hibernate.models.CommentReply;
import com.mpolivaha.hibernate.models.Post;
import com.mpolivaha.hibernate.models.PostComment;
import com.mpolivaha.hibernate.onetoone.User;
import com.mpolivaha.hibernate.HibernateTest.CurrentContext;
import com.mpolivaha.sdj.AbstractIntegrationTest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = CurrentContext.class)
class HibernateTest extends AbstractIntegrationTest {

  @Configuration(proxyBeanMethods = true)
  static class CurrentContext {

    @Bean
    public DriverManagerDataSource dataSource(
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
    public EntityManagerFactory entityManagerFactory(DriverManagerDataSource dataSource) {
      return Persistence.createEntityManagerFactory(
          "test-unit",
          Map.of(
              "jakarta.persistence.jdbc.url", dataSource.getUrl(),
              "jakarta.persistence.jdbc.user", dataSource.getUsername(),
              "jakarta.persistence.jdbc.password", dataSource.getPassword()
          )
      );
    }

    @Bean
    public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
      return entityManagerFactory.createEntityManager();
    }
  }

  @Autowired
  private EntityManager entityManager;

  @Test
  @Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, statements = """
      CREATE SCHEMA jpa;

      CREATE TABLE IF NOT EXISTS jpa.post(
        id BIGSERIAL PRIMARY KEY,
        title TEXT,
        content TEXT,
        created_at TIMESTAMP
      );

      CREATE TABLE IF NOT EXISTS jpa.post_comment(
        id BIGSERIAL PRIMARY KEY,
        comment TEXT,
        created_at TIMESTAMP,
        post_id BIGINT -- REFERENCES sdj.post(id)
      );

      CREATE TABLE IF NOT EXISTS jpa.comment_reply(
        id BIGSERIAL PRIMARY KEY,
        body TEXT,
        created_at TIMESTAMP,
        post_comment_id BIGINT -- REFERENCES sdj.post_comment(id)
      );
      """)
  @Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, statements = """
      DROP SCHEMA jpa CASCADE;
      """)
  void test_persistenceHappyPath() throws SQLException {
    Post post = buildPost();

    Connection connection = null;

    PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM foo_bar WHERE (fooNumber, barNumber) IN ((?, ?))");
    preparedStatement.setLong(1, 1);
    preparedStatement.setLong(1, 2);

    EntityTransaction transaction = entityManager.getTransaction();
    transaction.begin();
    entityManager.persist(post);
    transaction.commit();
  }

  @Test
  @Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, statements = """
      CREATE SCHEMA one_to_one;

      CREATE TABLE IF NOT EXISTS one_to_one.users(
        id BIGSERIAL PRIMARY KEY,
        name TEXT
      );

      CREATE TABLE IF NOT EXISTS one_to_one.address_info(
        id BIGSERIAL PRIMARY KEY,
        street TEXT,
        city TEXT,
        owner_id BIGINT REFERENCES one_to_one.users(id)
      );
      
      INSERT INTO one_to_one.users(id, name) VALUES(1, 'Alex');
      INSERT INTO one_to_one.address_info(street, city, owner_id) VALUES('Tverskaya', 'Moscow', 1);
      """)
  @Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, statements = """
      DROP SCHEMA one_to_one CASCADE;
      """)
  void test_loading_user() {
    EntityTransaction transaction = entityManager.getTransaction();
    transaction.begin();
    User user = entityManager.find(User.class, 1L);
    transaction.commit();

    System.out.println(user);
  }

  private static Post buildPost() {
    Post post = new Post()
        .setTitle("My post!")
        .setContent("Post content");

    PostComment postComment = new PostComment();
    postComment.setPost(post);
    postComment.setComment("Was cool!");
    postComment.setCreatedAt(Instant.now());

    post.setComments(List.of(postComment));

    CommentReply commentReply = new CommentReply();
    commentReply.setBody("Really?");
    commentReply.setCreatedAt(Instant.now());
    commentReply.setPostComment(postComment);

    postComment.setCommentReplies(List.of(commentReply));

    return post;
  }
}