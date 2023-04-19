import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    setup.java
    id("org.springframework.boot") version "3.0.5"
}
apply(plugin = "io.spring.dependency-management")


dependencies {
    implementation(project(JJUG.serviceApi))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.4")

    runtimeOnly(project(JJUG.service))
    runtimeOnly(project(JJUG.repositoryMemory))
}

tasks.named<BootJar>("bootJar") {
    mainClass.set("jp.ne.simplex.jjug.Main")
}
