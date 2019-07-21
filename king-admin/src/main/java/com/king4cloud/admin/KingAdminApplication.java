package com.king4cloud.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableAdminServer
@SpringBootApplication
public class KingAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(KingAdminApplication.class, args);
    }

}
