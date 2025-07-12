package com.example.studentManagement.domain.teaching.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.studentManagement.common.model.AggregateRoot;
import com.example.studentManagement.domain.teaching.event.CourseCreatedEvent;
import com.example.studentManagement.domain.teaching.event.CourseUpdatedEvent;
import com.example.studentManagement.domain.teaching.valueobject.CourseId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

/**
 * 课程聚合根
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("courses")
public class Course extends AggregateRoot {

    /**
     * 课程代码
     */
    @TableField("course_code")
    private String courseCode;

    /**
     * 课程名称
     */
    @TableField("course_name")
    private String courseName;

    /**
     * 课程描述
     */
    @TableField("description")
    private String description;

    /**
     * 学分
     */
    @TableField("credit_hours")
    private Integer creditHours;

    /**
     * 院系
     */
    @TableField("department")
    private String department;

    /**
     * 学期
     */
    @TableField("semester")
    private String semester;

    /**
     * 年份
     */
    @TableField("year")
    private Integer year;

    /**
     * 最大学生数
     */
    @TableField("max_students")
    private Integer maxStudents;

    /**
     * 当前学生数
     */
    @TableField("current_students")
    private Integer currentStudents;

    /**
     * 课程状态
     */
    @TableField("status")
    private Integer status;

    /**
     * 学生列表（不存储到数据库）
     */
    @TableField(exist = false)
    private Set<Student> students = new HashSet<>();

    /**
     * 创建课程
     * @param courseCode 课程代码
     * @param courseName 课程名称
     * @param creditHours 学分
     * @param maxStudents 最大学生数
     * @return 课程实体
     */
    public static Course create(String courseCode, String courseName, Integer creditHours, Integer maxStudents) {
        Course course = Course.builder()
                .courseCode(courseCode)
                .courseName(courseName)
                .creditHours(creditHours)
                .maxStudents(maxStudents)
                .currentStudents(0)
                .status(1) // 1表示开放
                .students(new HashSet<>())
                .build();

        // 发布课程创建事件
        course.addDomainEvent(new CourseCreatedEvent(course.getAggregateId(), course));
        
        return course;
    }

    /**
     * 更新课程信息
     * @param courseName 课程名称
     * @param description 课程描述
     * @param creditHours 学分
     * @param maxStudents 最大学生数
     */
    public void updateInfo(String courseName, String description, Integer creditHours, Integer maxStudents) {
        this.courseName = courseName;
        this.description = description;
        this.creditHours = creditHours;
        this.maxStudents = maxStudents;

        // 发布课程更新事件
        this.addDomainEvent(new CourseUpdatedEvent(this.getAggregateId(), this));
    }

    /**
     * 添加学生
     * @param student 学生
     */
    public void addStudent(Student student) {
        if (this.students == null) {
            this.students = new HashSet<>();
        }
        
        if (canEnroll()) {
            this.students.add(student);
            this.currentStudents = this.students.size();
        } else {
            throw new IllegalStateException("课程已满，无法添加学生");
        }
    }

    /**
     * 移除学生
     * @param student 学生
     */
    public void removeStudent(Student student) {
        if (this.students != null && this.students.contains(student)) {
            this.students.remove(student);
            this.currentStudents = this.students.size();
        }
    }

    /**
     * 是否可以选课
     * @return 是否可以选课
     */
    public boolean canEnroll() {
        return this.status == 1 && this.currentStudents < this.maxStudents;
    }

    /**
     * 是否已满
     * @return 是否已满
     */
    public boolean isFull() {
        return this.currentStudents >= this.maxStudents;
    }

    /**
     * 开放课程
     */
    public void open() {
        this.status = 1;
    }

    /**
     * 关闭课程
     */
    public void close() {
        this.status = 0;
    }

    /**
     * 获取空余席位
     * @return 空余席位数
     */
    public Integer getAvailableSeats() {
        return this.maxStudents - this.currentStudents;
    }

    @Override
    public String getAggregateId() {
        return CourseId.of(this.courseCode).getValue();
    }
} 