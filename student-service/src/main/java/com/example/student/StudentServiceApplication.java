package com.example.student;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 学生服务启动类
 * @author liujiandong
 */
@SpringBootApplication
@EnableFeignClients
@EnableTransactionManagement
@MapperScan("com.example.student.mapper")
@ComponentScan(basePackages = {
    "com.example.student",
    "com.example.common"
})
public class StudentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentServiceApplication.class, args);
    }
} 