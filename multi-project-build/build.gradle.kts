plugins {
    `kotlin-dsl`
}

allprojects {
    repositories {
        mavenCentral()
    }
}

tasks.withType<Wrapper> {
    gradleVersion = "8.0.2"
}

tasks.withType(Delete::class).getByName("clean") {
    delete("$projectDir/buildSrc/build")
}
