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

dependencies {
  // spring
  implementation("org.springframework.data:spring-data-jdbc:3.4.0")
  testImplementation("org.springframework.boot:spring-boot-starter-test:3.4.0")

  // logging
  testImplementation("ch.qos.logback:logback-classic:1.5.12")

  // lombok
  compileOnly("org.projectlombok:lombok:$lombokVersion")
  annotationProcessor("org.projectlombok:lombok:$lombokVersion")
  testCompileOnly("org.projectlombok:lombok:$lombokVersion")
  testAnnotationProcessor("org.projectlombok:lombok:$lombokVersion")

  testImplementation("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
  testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
  testImplementation("org.assertj:assertj-core:3.26.3")
  testImplementation("org.testcontainers:postgresql:1.20.4")

  // hibernate
  implementation("org.hibernate:hibernate-core:6.6.3.Final")

  // driver
  implementation("org.postgresql:postgresql:42.7.4")
}

tasks.test {
  useJUnitPlatform()
  testLogging.setShowStandardStreams(true)
}

repositories {
  mavenLocal()
  mavenCentral()
}