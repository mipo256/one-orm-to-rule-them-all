package com.mpolivaha.jimmer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mpolivaha.jimmer.JimmerTest.ApplicationPropertiesContextInitilizer;
import com.mpolivaha.jimmer.JimmerTest.CurrentConfiguration;
import com.mpolivaha.jimmer.dto.PostInput;
import com.mpolivaha.jimmer.models.CommentReplyDraft;
import com.mpolivaha.jimmer.models.Post;
import com.mpolivaha.jimmer.models.PostCommentDraft;
import com.mpolivaha.jimmer.models.PostDraft;
import com.mpolivaha.sdj.AbstractIntegrationTest;
import java.io.IOException;
import java.time.Instant;
import java.util.List;
import javax.sql.DataSource;
import org.babyfish.jimmer.spring.SqlClients;
import org.babyfish.jimmer.spring.cfg.JimmerProperties;
import org.babyfish.jimmer.sql.JSqlClient;
import org.babyfish.jimmer.sql.ast.mutation.AssociatedSaveMode;
import org.babyfish.jimmer.sql.ast.mutation.SaveMode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, statements = """
      CREATE SCHEMA jimmer;

      CREATE TABLE IF NOT EXISTS jimmer.post(
        id BIGSERIAL PRIMARY KEY,
        title TEXT,
        content TEXT,
        created_at TIMESTAMP
      );

      CREATE TABLE IF NOT EXISTS jimmer.post_comment(
        id BIGSERIAL PRIMARY KEY,
        comment TEXT,
        created_at TIMESTAMP,
        post_id BIGINT -- REFERENCES jimmer.post(id)
      );

      CREATE TABLE IF NOT EXISTS jimmer.comment_reply(
        id BIGSERIAL PRIMARY KEY,
        body TEXT,
        created_at TIMESTAMP,
        post_comment_id BIGINT -- REFERENCES jimmer.post_comment(id)
      );
      """)
@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, statements = """
      DROP SCHEMA jimmer CASCADE;
      """)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = CurrentConfiguration.class, initializers = ApplicationPropertiesContextInitilizer.class)
public class JimmerTest extends AbstractIntegrationTest {

  @Configuration
  static class ApplicationPropertiesContextInitilizer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
      try {
        applicationContext
            .getEnvironment()
            .getPropertySources()
            .addFirst(
                new ResourcePropertySource(new ClassPathResource("jimmer/jimmer.properties"))
            );
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }

  @Configuration
  @EnableConfigurationProperties(value = JimmerProperties.class)
  static class CurrentConfiguration {

    @Bean
    public DataSource dataSource(
        @Value("${spring.datasource.url}") String url,
        @Value("${spring.datasource.username}") String username,
        @Value("${spring.datasource.password}") String password
    ) {
      DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource(url, username, password);
      driverManagerDataSource.setSchema("jimmer");
      return driverManagerDataSource;
    }

    @Bean
    public ObjectMapper objectMapper() {
      return new ObjectMapper().registerModule(new JavaTimeModule());
    }

    @Bean
    JSqlClient sqlClient(
        ApplicationContext applicationContext,
        DataSource dataSource
    ) {
      return SqlClients.java(applicationContext, dataSource);
    }
  }

  @Autowired
  private JSqlClient jSqlClient;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private Environment environment;

  @Autowired
  private JimmerProperties jimmerProperties;

  @Test
  void testSavingDto() throws IOException {
    PostInput postInput = objectMapper.readValue(new ClassPathResource("jimmer/input.json").getInputStream(), PostInput.class);
    jSqlClient.save(postInput.toEntity(), SaveMode.INSERT_ONLY, AssociatedSaveMode.APPEND);
  }

  @Test
  void testSavingAdHoc() {
    Post post = PostDraft.$
        .produce(pDraft -> {
          pDraft.setTitle("Jimmer happy case");
          pDraft.setContent("Good luck searching bugs caused by this!");
          pDraft.setCreatedAt(null);
          pDraft.setComments(List.of(
              PostCommentDraft.$.produce(commentDraft -> {
                commentDraft.setComment("First comment");
                commentDraft.setCreatedAt(Instant.now().plusSeconds(15));
                commentDraft.setCommentReplies(List.of(
                    CommentReplyDraft.$.produce(replyDraft -> {
                      replyDraft.setBody("First reply!");
                      replyDraft.setCreatedAt(Instant.now().plusSeconds(25));
                    })
                ));
              })
          ));
        });

    jSqlClient.save(post, SaveMode.INSERT_ONLY, AssociatedSaveMode.APPEND);
  }
}
