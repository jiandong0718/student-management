package com.example.studentManagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

/**
 * 课程实体类
 *
 * @author liujiandong
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("courses")
public class Course {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("course_code")
    private String courseCode;

    @TableField("course_name")
    private String courseName;

    @TableField("description")
    private String description;

    @TableField("credit_hours")
    private Integer creditHours;

    @TableField("department")
    private String department;

    @TableField("semester")
    private String semester;

    @TableField("year")
    private Integer year;

    @TableField("max_students")
    private Integer maxStudents;

    @TableField("current_students")
    private Integer currentStudents = 0;

    /**
     * 0 开放、1 关闭、2 已满等
     */
    @TableField("status")
    private Integer status;

    @TableField(exist = false)
    private Set<Student> students = new HashSet<>();

    // 带参数的构造函数
    public Course(String courseCode, String courseName, Integer creditHours) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.creditHours = creditHours;
    }

    // 添加学生到课程
    public void addStudent(Student student) {
        this.students.add(student);
        if (this.currentStudents == null) {
            this.currentStudents = 0;
        }
        this.currentStudents++;
    }

    // 从课程中移除学生
    public void removeStudent(Student student) {
        this.students.remove(student);
        if (this.currentStudents > 0) {
            this.currentStudents--;
        }
    }
}
