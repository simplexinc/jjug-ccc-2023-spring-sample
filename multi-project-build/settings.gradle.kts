rootProject.name = "multi-project"

include("jjug-domain")
include("jjug-repository")
include("jjug-server")

dependencyResolutionManagement {
    versionCatalogs {
        create("lib") {
            val slf4jVersion = version("slf4j", "1.7.+")
            library("slf4j-simple", "org.slf4j", "slf4j-simple").versionRef(slf4jVersion)

            val logbackVersion = version("logback", "1.4.+")
            library("logback-classic", "ch.qos.logback", "logback-classic").versionRef(logbackVersion)

            // ProtocolBuffers, GRPC
            val protobufVersion = version("protobuf", "3.19.+")
            library("proto-java", "com.google.protobuf", "protobuf-java").versionRef(protobufVersion)
            library("proto-kotlin", "com.google.protobuf", "protobuf-kotlin").versionRef(protobufVersion)
            library("proto-protoc", "com.google.protobuf", "protoc").versionRef(protobufVersion)

            val grpcVersion = version("gRPC", "1.41.+")
            val grpcKotlinVersion = version("gRPCKotlin", "1.2.+")
            library("grpc-api", "io.grpc", "grpc-api").versionRef(grpcVersion)
            library("grpc-protobuf", "io.grpc", "grpc-protobuf").versionRef(grpcVersion)
            library("grpc-gen", "io.grpc", "protoc-gen-grpc-java").versionRef(grpcVersion)
            library("grpc-genKotlin", "io.grpc", "protoc-gen-grpc-kotlin").versionRef(grpcKotlinVersion)
            library("grpc-stub", "io.grpc", "grpc-stub").versionRef(grpcVersion)
            library("grpc-stubKotlin", "io.grpc", "grpc-kotlin-stub").versionRef(grpcKotlinVersion)
            library("grpc-netty", "io.grpc", "grpc-netty").versionRef(grpcVersion)
            library("grpc-testing", "io.grpc", "grpc-testing").versionRef(grpcVersion)

            // Server

            // Test
            val jUnitVersion = version("jUnit", "5.9.+")
            library("junit5", "org.junit.jupiter", "junit-jupiter").versionRef(jUnitVersion)

            bundle(
                "common-proto-implementation", listOf(
                    "javax-annotation-api",
                    "proto-java",
                    "proto-kotlin",
                    "grpc-stub",
                    "grpc-stubKotlin",
                    "grpc-protobuf",
                )
            )
        }
    }
}
