package com.atguigu.mybatis_plus_boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.atguigu.mybatis_plus_boot.mapper")
@SpringBootApplication
public class MybatisPlusBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusBootApplication.class, args);
    }

}
