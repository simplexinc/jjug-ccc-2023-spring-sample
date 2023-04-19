package jp.ne.simplex.jjug;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(
        scanBasePackages = {
                "jp.ne.simplex.jjug.module",
                "jp.ne.simplex.jjug.controller",
        }
)
public class Main {
    public static String BASE_PACKAGE = "jp.ne.simplex.jjug";

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
