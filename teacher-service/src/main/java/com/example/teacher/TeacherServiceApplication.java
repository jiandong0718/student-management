package com.example.teacher;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 教师服务启动类
 * @author liujiandong
 */
@SpringBootApplication
@EnableFeignClients
@EnableTransactionManagement
@MapperScan("com.example.teacher.mapper")
@ComponentScan(basePackages = {
    "com.example.teacher",
    "com.example.common"
})
public class TeacherServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeacherServiceApplication.class, args);
    }
} 