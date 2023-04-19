plugins {
    setup.java
}

dependencies {
    implementation(project(JJUG.repositoryApi))
    implementation(project(JJUG.serviceApi))

    implementation("org.springframework:spring-context:6.0.7")
}
