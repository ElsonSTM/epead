package com.epead.authu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AuthuApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthuApplication.class, args);
    }

}
