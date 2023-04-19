plugins {
    `kotlin-dsl`
    java
    `java-library`
}

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

tasks.withType<Wrapper> {
    gradleVersion = "8.0.2"
}

dependencies {
}
