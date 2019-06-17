package com.king4cloud.king.biz.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringCloudApplication
@EnableFeignClients
@MapperScan(basePackages = {"com.king4cloud.king"})
public class KingBizUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(KingBizUserApplication.class, args);
    }

}
