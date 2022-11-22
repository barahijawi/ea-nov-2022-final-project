package com.example.commentsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication

public class CommentsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommentsServiceApplication.class, args);
    }

}
