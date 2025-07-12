package com.example.studentManagement.domain.teaching.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.studentManagement.common.model.AggregateRoot;
import com.example.studentManagement.domain.teaching.event.StudentEnrolledEvent;
import com.example.studentManagement.domain.teaching.event.StudentUpdatedEvent;
import com.example.studentManagement.domain.teaching.valueobject.StudentId;
import com.example.studentManagement.domain.teaching.valueobject.StudentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * 学生聚合根
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("students")
public class Student extends AggregateRoot {

    /**
     * 学号
     */
    @TableField("student_id")
    private String studentId;

    /**
     * 姓名
     */
    @TableField("first_name")
    private String firstName;

    @TableField("last_name")
    private String lastName;

    /**
     * 邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 电话号码
     */
    @TableField("phone_number")
    private String phoneNumber;

    /**
     * 出生日期
     */
    @TableField("date_of_birth")
    private LocalDate dateOfBirth;

    /**
     * 性别
     */
    @TableField("gender")
    private String gender;

    /**
     * 地址
     */
    @TableField("address")
    private String address;

    /**
     * 入学日期
     */
    @TableField("enrollment_date")
    private LocalDate enrollmentDate;

    /**
     * 毕业日期
     */
    @TableField("graduation_date")
    private LocalDate graduationDate;

    /**
     * 专业
     */
    @TableField("major")
    private String major;

    /**
     * 平均绩点
     */
    @TableField("gpa")
    private Double gpa;

    /**
     * 学生状态
     */
    @TableField("status")
    private String status;

    /**
     * 选课列表（不存储到数据库）
     */
    @TableField(exist = false)
    private Set<Course> courses = new HashSet<>();

    /**
     * 创建学生
     * @param studentId 学号
     * @param firstName 名字
     * @param lastName 姓氏
     * @param email 邮箱
     * @return 学生实体
     */
    public static Student create(String studentId, String firstName, String lastName, String email) {
        Student student = Student.builder()
                .studentId(studentId)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .status(StudentStatus.ACTIVE.getValue())
                .enrollmentDate(LocalDate.now())
                .gpa(0.0)
                .courses(new HashSet<>())
                .build();

        // 发布学生注册事件
        student.addDomainEvent(new StudentEnrolledEvent(student.getAggregateId(), student));
        
        return student;
    }

    /**
     * 更新学生信息
     * @param firstName 名字
     * @param lastName 姓氏
     * @param email 邮箱
     * @param phoneNumber 电话号码
     * @param address 地址
     * @param major 专业
     */
    public void updateInfo(String firstName, String lastName, String email, String phoneNumber, String address, String major) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.major = major;

        // 发布学生信息更新事件
        this.addDomainEvent(new StudentUpdatedEvent(this.getAggregateId(), this));
    }

    /**
     * 选课
     * @param course 课程
     */
    public void enrollCourse(Course course) {
        if (this.courses == null) {
            this.courses = new HashSet<>();
        }
        
        if (!this.courses.contains(course)) {
            this.courses.add(course);
            course.addStudent(this);
        }
    }

    /**
     * 退课
     * @param course 课程
     */
    public void withdrawCourse(Course course) {
        if (this.courses != null && this.courses.contains(course)) {
            this.courses.remove(course);
            course.removeStudent(this);
        }
    }

    /**
     * 获取全名
     * @return 全名
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }

    /**
     * 是否活跃学生
     * @return 是否活跃
     */
    public boolean isActive() {
        return StudentStatus.ACTIVE.getValue().equals(this.status);
    }

    /**
     * 毕业
     */
    public void graduate() {
        this.status = StudentStatus.GRADUATED.getValue();
        this.graduationDate = LocalDate.now();
    }

    /**
     * 休学
     */
    public void suspend() {
        this.status = StudentStatus.SUSPENDED.getValue();
    }

    /**
     * 复学
     */
    public void resume() {
        this.status = StudentStatus.ACTIVE.getValue();
    }

    @Override
    public String getAggregateId() {
        return StudentId.of(this.studentId).getValue();
    }
} 