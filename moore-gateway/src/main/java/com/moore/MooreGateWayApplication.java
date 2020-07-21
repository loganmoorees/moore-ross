package com.moore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MooreGateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(MooreGateWayApplication.class, args);
    }
}
