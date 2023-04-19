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
    runtimeOnly(lib.springdoc.openapi.starter.webmvc.ui) // Swaggerを利用するために追加

    runtimeOnly(project(JJUG.service))
    runtimeOnly(project(JJUG.repositoryMemory))

    // implementation(lib.bundles.common.proto.implementation)
}
