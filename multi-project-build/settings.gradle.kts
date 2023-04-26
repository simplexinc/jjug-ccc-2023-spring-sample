rootProject.name = "multi-project"

include("jjug-domain")
include("jjug-repository-api")
include("jjug-repository-memory")
include("jjug-service-api")
include("jjug-service")
include("jjug-server")

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
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

            bundle(
                "common-proto-implementation", listOf(
                    "proto-java",
                    "proto-kotlin",
                    "grpc-stub",
                    "grpc-stubKotlin",
                    "grpc-protobuf",
                )
            )

            // Server
            val springVersion = version("spring", "6.0.7")
            val springBootVersion = version("springBoot", "3.0.5")
            val springDocVersion = version("springDoc", "2.0.4")
            library("spring-context","org.springframework","spring-context").versionRef(springVersion)
            library("spring-boot-starter-web","org.springframework.boot","spring-boot-starter-web").versionRef(springBootVersion)
            library("springdoc-openapi-starter-webmvc-ui","org.springdoc","springdoc-openapi-starter-webmvc-ui").versionRef(springDocVersion)

            // Test
            val jUnitVersion = version("jUnit", "5.9.+")
            library("junit5", "org.junit.jupiter", "junit-jupiter").versionRef(jUnitVersion)
        }
    }
}
