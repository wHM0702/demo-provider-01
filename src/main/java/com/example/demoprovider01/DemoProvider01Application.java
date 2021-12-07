package com.example.demoprovider01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.example.demoprovider01.dao")
public class DemoProvider01Application {

    public static void main(String[] args) {
        SpringApplication.run(DemoProvider01Application.class, args);
    }

}
