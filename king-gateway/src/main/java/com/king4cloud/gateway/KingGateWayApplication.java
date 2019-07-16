package com.king4cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.king4cloud"})
public class KingGateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(KingGateWayApplication.class, args);
    }

}
