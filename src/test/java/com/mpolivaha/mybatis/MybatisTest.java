package com.mpolivaha.mybatis;

import com.mpolivaha.mybatis.MybatisTest.CurrentContext;
import com.mpolivaha.mybatis.dynamic.Post;
import com.mpolivaha.sdj.AbstractIntegrationTest;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import lombok.SneakyThrows;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = CurrentContext.class)
public class MybatisTest extends AbstractIntegrationTest {

  @TestConfiguration(proxyBeanMethods = true)
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
    SqlSessionFactory sqlSessionFactoryBean(DriverManagerDataSource dataSource) throws Exception {
      SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
      sqlSessionFactoryBean.setDataSource(dataSource);
      sqlSessionFactoryBean.setMapperLocations(new ClassPathResource("mybatis.xml"));
      return sqlSessionFactoryBean.getObject();
    }

    @Bean
    SqlSession sqlSession(SqlSessionFactory sqlSessionFactory) {
      return sqlSessionFactory.openSession();
    }
  }

  @Autowired
  SqlSession sqlSession;

  @Test
  @Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, statements = """
      DROP SCHEMA IF EXISTS mybatis CASCADE;
      CREATE SCHEMA mybatis;

      CREATE TABLE IF NOT EXISTS mybatis.post(
        id BIGSERIAL PRIMARY KEY,
        title TEXT,
        content TEXT,
        created_at TIMESTAMP
      );

      CREATE TABLE IF NOT EXISTS mybatis.post_comment(
        id BIGSERIAL PRIMARY KEY,
        comment TEXT,
        created_at TIMESTAMP,
        post_id BIGINT REFERENCES mybatis.post(id)
      );

      CREATE TABLE IF NOT EXISTS mybatis.comment_reply(
        id BIGSERIAL PRIMARY KEY,
        body TEXT,
        created_at TIMESTAMP,
        post_comment_id BIGINT REFERENCES mybatis.post_comment(id)
      );
      """)
  void testHappyPath() {
    var post = new com.mpolivaha.mybatis.Post();
    post.setTitle("MyBatis Framework");
    post.setContent("Content of the article");
    post.setCreatedAt(Instant.now());
    post.setId(1L);

    PostComment postComment = new PostComment();
    postComment.setPost(post);
    postComment.setComment("Mybatis comment!");
    postComment.setId(1L);
    postComment.setCreatedAt(Instant.now());

    CommentReply commentReply = new CommentReply();
    commentReply.setPostComment(postComment);
    commentReply.setBody("Comment Body o_0");
    commentReply.setCreatedAt(Instant.now());
    commentReply.setId(1L);

    sqlSession.insert("com.snowone.mybatis.insertPost", post);
    sqlSession.insert("com.snowone.mybatis.insertPostComment", postComment);
    sqlSession.insert("com.snowone.mybatis.insertCommentReply", commentReply);
  }

  @SneakyThrows
  @Test
  @Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, statements = """
      DROP SCHEMA IF EXISTS mybatis CASCADE;
      CREATE SCHEMA mybatis;

      CREATE TABLE IF NOT EXISTS mybatis.posts(
        id BIGSERIAL,
        topic TEXT,
        score REAL,
        created_at TIMESTAMP
      );
      
      INSERT INTO mybatis.posts(id, topic, score, created_at) SELECT
        generate_series(0, 100),
        CASE floor(random() * 4)
           WHEN 0 THEN 'databases'
           WHEN 1 THEN 'operating-systems'
           WHEN 2 THEN 'compilers'
           WHEN 3 THEN 'computer-science'
        END,
        random() * 10,
        NOW() - (((random() * 100)::text) || ' days')::INTERVAL;
      """)
  // deep reflection needs to be allowed
  void testLoadingDynamicComplexQuery_compilersTop5() {
    List<Post> posts = sqlSession.selectList(
        "com.snowone.mybatis.findTopPosts",
        Map.of(
            "top_n", 5,
            "topics", List.of("compilers")
        )
    );

    print(posts);
  }

  private static void print(List<Post> posts) {
    var writer = new ObjectMapper().writerWithDefaultPrettyPrinter();

    posts.forEach(post -> {
      try {
        System.out.println(writer.writeValueAsString(post));
      } catch (JsonProcessingException e) {
        throw new RuntimeException(e);
      }
    });
  }
}
