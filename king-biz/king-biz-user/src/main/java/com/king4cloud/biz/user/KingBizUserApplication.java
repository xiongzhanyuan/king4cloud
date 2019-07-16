package com.king4cloud.biz.user;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


@SpringCloudApplication
@EnableFeignClients
@EnableSwagger2Doc
@MapperScan(basePackages = {"com.king4cloud"})
@ComponentScan(basePackages = {"com.king4cloud"})
public class KingBizUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(KingBizUserApplication.class, args);
    }

}
