package org.example.praktika1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("org.example.praktika1.repositories")
public class Praktika1Application {
    public static void main(String[] args) {
        SpringApplication.run(Praktika1Application.class, args);
    }
}
