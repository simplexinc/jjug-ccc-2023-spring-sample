import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    setup.java
    id("org.springframework.boot") version lib.versions.springBoot
}

tasks.named<BootJar>("bootJar") {
    mainClass.set("jp.ne.simplex.jjug.Main")
}

dependencies {
    implementation(project(JJUG.serviceApi))

    implementation(lib.spring.boot.starter.web)
    implementation(lib.springdoc.openapi.starter.webmvc.ui)

    runtimeOnly(project(JJUG.service))
    runtimeOnly(project(JJUG.repositoryMemory))

    // implementation(lib.bundles.common.proto.implementation)
}
