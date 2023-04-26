plugins {
    setup.java
}

dependencies {
    implementation(project(JJUG.repositoryApi))
    implementation(project(JJUG.serviceApi))

    implementation(libs.spring.context)
}
