import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    `kotlin-dsl`
    java
    `java-library`
    id("org.springframework.boot") version "3.0.5"
}
apply(plugin = "io.spring.dependency-management")

repositories {
    mavenCentral()
}

group="jp.ne.simplex"
version="0.1.0-SNAPSHOT"

extensions.getByType<JavaPluginExtension>().apply {
    withJavadocJar()
    withSourcesJar()
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
        vendor.set(JvmVendorSpec.AMAZON)
    }
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}

tasks.withType<Javadoc>().configureEach {
    options.encoding = "UTF-8"
    (options as CoreJavadocOptions).addStringOption("Xdoclint:none", "-quiet")
}

tasks.withType<Jar> {
    exclude(".gitkeep")
}

tasks.named<BootJar>("bootJar") {
    mainClass.set("jp.ne.simplex.jjug.Main")
}

tasks.withType<Wrapper> {
    gradleVersion = "8.0.2"
}

dependencies {
    implementation("jp.ne.simplex:composite-jjug-service-api:0.1.0-SNAPSHOT")

    implementation("org.springframework.boot:spring-boot-starter-web"){
        // Gradle のgenerated-jarとLoggerFactoryの衝突が起きるため暫定的に回避(本当はgenerated^jarを外すべき)
        exclude("ch.qos.logback", "logback-classic")
    }
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.4")

    runtimeOnly("jp.ne.simplex:composite-jjug-repository-memory:0.1.0-SNAPSHOT")
    runtimeOnly("jp.ne.simplex:composite-jjug-service:0.1.0-SNAPSHOT")
}
