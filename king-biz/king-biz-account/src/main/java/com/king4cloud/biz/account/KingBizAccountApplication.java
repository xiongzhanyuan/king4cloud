package com.king4cloud.biz.account;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringCloudApplication
@MapperScan(basePackages = {"com.king4cloud"})
@EnableSwagger2Doc
@ComponentScan(basePackages = {"com.king4cloud"})
public class KingBizAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(KingBizAccountApplication.class, args);
    }

}
