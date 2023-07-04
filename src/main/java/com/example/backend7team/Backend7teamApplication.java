package com.example.backend7team;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@EnableJpaAuditing
@EnableRedisRepositories
@ConfigurationPropertiesScan
@SpringBootApplication
public class Backend7teamApplication {

    public static void main(String[] args) {
        SpringApplication.run(Backend7teamApplication.class, args);
    }
}
