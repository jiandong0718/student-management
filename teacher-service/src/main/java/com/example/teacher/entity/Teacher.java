package com.example.teacher.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.common.model.BaseEntity;
import lombok.*;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * 教师实体类
 *
 * @author liujiandong
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true, of = {"teacherId"})
@ToString(callSuper = true)
@TableName("teachers")
public class Teacher extends BaseEntity {

    @TableField("teacher_id")
    @NotBlank(message = "教师编号不能为空")
    private String teacherId; // 教师编号

    @TableField("first_name")
    @NotBlank(message = "名字不能为空")
    private String firstName;

    @TableField("last_name")
    @NotBlank(message = "姓氏不能为空")
    private String lastName;

    @TableField("email")
    @Email(message = "邮箱格式不正确")
    @NotBlank(message = "邮箱不能为空")
    private String email;

    @TableField("phone_number")
    private String phoneNumber;

    @TableField("date_of_birth")
    private LocalDate dateOfBirth;

    @TableField("gender")
    private String gender;

    @TableField("address")
    private String address;

    @TableField("hire_date")
    @NotNull(message = "入职日期不能为空")
    private LocalDate hireDate;

    @TableField("department")
    @NotBlank(message = "部门不能为空")
    private String department;

    @TableField("position")
    @NotBlank(message = "职位不能为空")
    private String position;

    @TableField("salary")
    private Double salary;

    @TableField("office_location")
    private String officeLocation;

    /**
     * 在职、离职、退休等
     */
    @TableField("status")
    @NotBlank(message = "状态不能为空")
    private String status;

    @TableField("qualification")
    private String qualification; // 学历

    @TableField("specialization")
    private String specialization; // 专业

    // 带参数的构造函数
    public Teacher(String teacherId, String firstName, String lastName, String email, String department) {
        this.teacherId = teacherId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.department = department;
    }
    
    /**
     * 获取教师全名
     * @return 全名
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }
    
    /**
     * 判断是否为在职状态
     * @return 是否在职
     */
    public boolean isActive() {
        return "ACTIVE".equals(status);
    }
    
    /**
     * 计算工龄（年）
     * @return 工龄年数
     */
    public int getYearsOfService() {
        if (hireDate == null) {
            return 0;
        }
        return LocalDate.now().getYear() - hireDate.getYear();
    }
} 