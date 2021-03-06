package com.king4cloud;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringCloudApplication
@EnableFeignClients
@EnableSwagger2Doc
@MapperScan(basePackages = {"com.king4cloud"})
public class KingAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(KingAuthApplication.class, args);
    }
}
