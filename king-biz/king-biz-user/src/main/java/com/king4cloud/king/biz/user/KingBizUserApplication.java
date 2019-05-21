package com.king4cloud.king.biz.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class KingBizUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(KingBizUserApplication.class, args);
    }

}
