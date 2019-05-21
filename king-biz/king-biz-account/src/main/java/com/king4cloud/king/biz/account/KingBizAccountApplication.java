package com.king4cloud.king.biz.account;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan(basePackages = {"com.king4cloud.king"})
public class KingBizAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(KingBizAccountApplication.class, args);
    }

}
