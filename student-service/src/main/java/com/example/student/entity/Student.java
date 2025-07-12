package com.example.student.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.common.model.BaseEntity;
import lombok.*;

import java.time.LocalDate;

/**
 * 学生实体类
 *
 * @author liujiandong
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true, of = {"studentId"})
@ToString(callSuper = true)
@TableName("students")
public class Student extends BaseEntity {

    @TableField("student_id")
    private String studentId; // 学号

    @TableField("first_name")
    private String firstName;

    @TableField("last_name")
    private String lastName;

    @TableField("email")
    private String email;

    @TableField("phone_number")
    private String phoneNumber;

    @TableField("date_of_birth")
    private LocalDate dateOfBirth;

    @TableField("gender")
    private String gender;

    @TableField("address")
    private String address;

    @TableField("enrollment_date")
    private LocalDate enrollmentDate;

    @TableField("graduation_date")
    private LocalDate graduationDate;

    @TableField("major")
    private String major;

    @TableField("gpa")
    private Double gpa;

    /**
     * 在读、休学、毕业等
     */
    @TableField("status")
    private String status;

    // 带参数的构造函数
    public Student(String studentId, String firstName, String lastName, String email) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    
    /**
     * 获取学生全名
     * @return 全名
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }
    
    /**
     * 判断是否为在读状态
     * @return 是否在读
     */
    public boolean isActive() {
        return "ACTIVE".equals(status);
    }
} 