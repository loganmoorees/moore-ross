package com.moore.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MooreDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(MooreDataApplication.class, args);
    }
}
