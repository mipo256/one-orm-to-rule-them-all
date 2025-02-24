plugins {
  id("java")
  id("com.dorongold.task-tree") version "4.0.0"
}

java {
  toolchain {
    languageVersion = JavaLanguageVersion.of(17)
  }
}


sourceSets {
  main {
    java {
      srcDir("src/main/java")
    }
    resources {
      srcDir("src/main/resources")
    }
  }
}

val lombokVersion = "1.18.36"
val junitVersion = "5.11.3"
val jimmerVersion = "0.9.37"

dependencies {
  // spring bom
  implementation(platform("org.springframework.boot:spring-boot-starter-parent:3.4.0"))

  // spring
  implementation("org.springframework.data:spring-data-jdbc")
  implementation("org.springframework.data:spring-data-jpa")
  testImplementation("org.springframework.boot:spring-boot-starter-test")

  // logging
  testImplementation("ch.qos.logback:logback-classic")

  // lombok
  compileOnly("org.projectlombok:lombok:$lombokVersion")
  annotationProcessor("org.projectlombok:lombok:$lombokVersion")
  testCompileOnly("org.projectlombok:lombok:$lombokVersion")
  testAnnotationProcessor("org.projectlombok:lombok:$lombokVersion")

  // jimmer
  implementation("org.babyfish.jimmer:jimmer-spring-boot-starter:${jimmerVersion}")
  annotationProcessor("org.babyfish.jimmer:jimmer-apt:${jimmerVersion}")
  compileOnly("org.babyfish.jimmer:jimmer-sql:${jimmerVersion}")
  implementation("org.babyfish.jimmer:jimmer-core:${jimmerVersion}")

  testImplementation("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
  testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
  testImplementation("org.assertj:assertj-core")
  testImplementation("org.testcontainers:postgresql")

  // hibernate
  implementation("org.hibernate:hibernate-core:6.6.4.Final")

  // mybatis
  implementation("org.mybatis:mybatis:3.5.7")
  implementation("org.mybatis:mybatis-spring:3.0.4")

  // driver
  implementation("org.postgresql:postgresql")

  // other
  implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
}

tasks.test {
  useJUnitPlatform()
  testLogging.setShowStandardStreams(true)
}

repositories {
  mavenLocal()
  mavenCentral()
}