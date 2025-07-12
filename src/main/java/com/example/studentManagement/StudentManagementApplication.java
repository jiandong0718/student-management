package com.example.studentManagement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 学生管理系统启动类
 * @author liujiandong
 */
@SpringBootApplication
@ComponentScan(basePackages = {
    "com.example.studentManagement",
    "com.example.common"
})
@MapperScan(basePackages = {
    "com.example.studentManagement.mapper",
    "com.example.common.mapper"
})
public class StudentManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementApplication.class, args);
    }

}
