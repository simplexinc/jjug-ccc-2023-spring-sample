import org.gradle.api.Project


@Suppress("UNCHECKED_CAST")  // なぜかキャストが必要
open class ProjectGroup(private vararg val paths: String = arrayOf("")) {
    internal fun project(name: String) = Project(*(paths as Array<String>).plus(name))
    inner class Project(private vararg val paths: String) {
        val path get() = paths.joinToString(":")
    }
}

fun Project.project(project: ProjectGroup.Project): Project = project(project.path)

object JJUG : ProjectGroup("") {
    val domain = project("jjug-domain")
    val repositoryApi = project("jjug-repository-api")
    val repositoryMemory = project("jjug-repository-memory")
    val serviceApi = project("jjug-service-api")
    val service = project("jjug-service")
    val server = project("jjug-server")
}


internal const val protocArtifact = "com.google.protobuf:protoc:3.22.+"
internal const val grpcJavaGenArtifact = "io.grpc:protoc-gen-grpc-java:1.54.+"
internal const val grpcKotlinGenArtifact = "io.grpc:protoc-gen-grpc-kotlin:1.3.+:jdk8@jar"
