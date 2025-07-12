package com.example.studentManagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * 选课记录实体类
 *
 * @author liujiandong
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("enrollments")
public class Enrollment {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(exist = false)
    private Student student;

    @TableField("student_id")
    private Long studentId;

    @TableField(exist = false)
    private Course course;

    @TableField("course_id")
    private Long courseId;

    @TableField("enrollment_date")
    private LocalDate enrollmentDate;

    @TableField("grade")
    private Double grade;

    /**
     * 0 已注册、1 已完成、2 已退课等
     */
    @TableField("status")
    private Integer status;

    @TableField("semester")
    private String semester;

    @TableField("year")
    private Integer year;

    @TableField("comments")
    private String comments;

    // 带参数的构造函数
    public Enrollment(Student student, Course course, LocalDate enrollmentDate) {
        this.student = student;
        this.studentId = student.getId();
        this.course = course;
        this.courseId = course.getId();
        this.enrollmentDate = enrollmentDate;
        this.status = 0;
    }
}
