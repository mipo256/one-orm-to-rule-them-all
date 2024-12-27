package com.mpolivaha.sdj.repository;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

public class AbstractIntegrationTest {

  protected static final PostgreSQLContainer<?> INSTANCE = new PostgreSQLContainer<>(DockerImageName.parse("postgres:15.2"));

  @DynamicPropertySource
  static void register(DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.url", INSTANCE::getJdbcUrl);
    registry.add("spring.datasource.password", INSTANCE::getUsername);
    registry.add("spring.datasource.username", INSTANCE::getUsername);
  }

  @BeforeAll
  static void beforeAll() {
    INSTANCE.start();
  }

  @AfterAll
  static void afterAll() {
    INSTANCE.stop();
  }
}
