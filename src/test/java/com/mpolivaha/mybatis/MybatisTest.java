package com.mpolivaha.mybatis;

import com.mpolivaha.mybatis.MybatisTest.CurrentContext;
import com.mpolivaha.mybatis.model.Post;
import com.mpolivaha.sdj.AbstractIntegrationTest;
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

@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, statements = """
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
@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, statements = """
      DROP SCHEMA mybatis CASCADE;
      """)
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

  @SneakyThrows
  @Test
  void testLoadingDynamicComplexQuery_compilersTop5() {
    List<Post> posts = sqlSession.selectList(
        "com.jugnsk.mybatis.findTopPosts",
        Map.of(
            "top_n", 5,
            "topics", List.of("compilers")
        )
    );

    print(posts);
  }

  @SneakyThrows
  @Test
  void testLoadingDynamicComplexQuery_databasesTop3() {
    List<Post> posts = sqlSession.selectList(
        "com.jugnsk.mybatis.findTopPosts",
        Map.of(
            "top_n", 3,
            "topics", List.of("databases")
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
