package com.king4cloud.common.core.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

import static com.baomidou.mybatisplus.annotation.DbType.MYSQL;

@Configuration
@ConditionalOnClass({DruidDataSource.class,DataSource.class})
@ConditionalOnMissingBean(name = "MySQLNoUse")
public class MybatisConfiguration {

    /**
     *  druid 初始化
     * @return
     */
    @Bean
    public DataSource dataSource() {
        return DruidDataSourceBuilder.create().build();
    }


    /**
     * 分页插件
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setDialectType(MYSQL.getDb());
        return paginationInterceptor;
    }
    /**
     * 性能分析插件  性能分析拦截器，用于输出每条 SQL 语句及其执行时间
     */
    @Bean
//    @Profile({"dev","test"})// 设置 dev test 环境开启
    public PerformanceInterceptor performanceInterceptor(){
        return new PerformanceInterceptor();
    }

}
