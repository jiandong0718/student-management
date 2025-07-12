package com.example.studentManagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * 学生实体类
 *
 * @author liujiandong
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id", "studentId"})
@ToString(exclude = "courses")
@TableName("students")
public class Student {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

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

    @TableField(exist = false)
    private Set<Course> courses = new HashSet<>();

    // 带参数的构造函数
    public Student(String studentId, String firstName, String lastName, String email) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // 添加课程
    public void addCourse(Course course) {
        this.courses.add(course);
        course.getStudents().add(this);
    }

    // 移除课程
    public void removeCourse(Course course) {
        this.courses.remove(course);
        course.getStudents().remove(this);
    }
}
