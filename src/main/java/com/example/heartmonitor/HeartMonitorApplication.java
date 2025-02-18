package com.example.heartmonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.heartmonitor.repository")
@EntityScan(basePackages = "com.example.heartmonitor.model")
public class HeartMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeartMonitorApplication.class, args);
    }
}
