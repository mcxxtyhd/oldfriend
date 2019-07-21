package com.feng.oldfriend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class OldfriendApplication {

    public static void main(String[] args) {
        SpringApplication.run(OldfriendApplication.class, args);
    }

}
