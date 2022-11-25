import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.0.0"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("jvm") version "1.7.21"
    kotlin("plugin.spring") version "1.7.21"
    kotlin("plugin.jpa") version "1.7.21"
    // For classes such as JPA, makes non-final (kotlin final by default)
    kotlin("plugin.allopen") version "1.7.21"

    kotlin("kapt") version "1.7.21"
}

group = "org.lucidant"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_16

configurations {
    testImplementation { exclude(group = "org.junit.vintage") }
}

repositories {
    mavenCentral()
}

dependencies {
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-mustache")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    implementation ("org.springframework.data:spring-data-relational:2.4.5")

    // OpenAPI with nice swagger UI
    implementation("io.springfox:springfox-swagger2:3.0.0")
    runtimeOnly("org.springdoc:springdoc-openapi-ui:1.6.12")
    runtimeOnly("io.springfox:springfox-swagger-ui:3.0.0")

    // Database
    runtimeOnly("com.h2database:h2")

    developmentOnly("org.springframework.boot:spring-boot-devtools")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
    testImplementation("com.ninja-squad:springmockk:3.1.1")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "16"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.Embeddable")
    annotation("javax.persistence.MappedSuperclass")
}

//tasks {
//    test {
//        useJUnitPlatform()
//        testLogging.showExceptions = true
//        testLogging.showStackTraces = true
//        exclude("**/*IntTest*")
//
//        val failedTests = mutableListOf<TestDescriptor>()
//        val skippedTests = mutableListOf<TestDescriptor>()
//
//        // See https://github.com/gradle/kotlin-dsl/issues/836
//        addTestListener(object : TestListener {
//            override fun beforeSuite(suite: TestDescriptor) {}
//            override fun beforeTest(testDescriptor: TestDescriptor) {}
//            override fun afterTest(testDescriptor: TestDescriptor, result: TestResult) {
//                when (result.resultType) {
//                    TestResult.ResultType.FAILURE -> failedTests.add(testDescriptor)
//                    TestResult.ResultType.SKIPPED -> skippedTests.add(testDescriptor)
//                }
//            }
//
//            override fun afterSuite(suite: TestDescriptor, result: TestResult) {
//                if (suite.parent == null) { // root suite
//                    logger.lifecycle("----")
//                    logger.lifecycle("Test result: ${result.resultType}")
//                    logger.lifecycle(
//                        "Test summary: ${result.testCount} tests, " +
//                                "${result.successfulTestCount} succeeded, " +
//                                "${result.failedTestCount} failed, " +
//                                "${result.skippedTestCount} skipped"
//                    )
//                    if (failedTests.isNotEmpty()) {
//                        logger.lifecycle("\tFailed Tests:")
//                        failedTests.forEach {
//                            parent?.let { parent ->
//                                logger.lifecycle("\t\t${parent.name} - ${it.name}")
//                            } ?: logger.lifecycle("\t\t${it.name}")
//                        }
//                    }
//
//                    if (skippedTests.isNotEmpty()) {
//                        logger.lifecycle("\tSkipped Tests:")
//                        skippedTests.forEach {
//                            parent?.let { parent ->
//                                logger.lifecycle("\t\t${parent.name} - ${it.name}")
//                            } ?: logger.lifecycle("\t\t${it.name}")
//                        }
//                    }
//                }
//            }
//        })
//    }
//}
//
//task<Test>("integrationTest") {
//    description = "Runs the integration tests"
//    group = "verification"
//    testLogging.showExceptions = true
//    testLogging.showStackTraces = true
//    include("**/*IntTest*")
//}
