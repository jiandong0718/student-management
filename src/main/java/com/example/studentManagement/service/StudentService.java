package com.example.studentManagement.service;

import com.example.studentManagement.entity.Student;
import java.util.List;

/**
 * 学生服务接口
 * @author liujiandong
 */
public interface StudentService {

    /**
     * 根据ID查询学生
     * @param id 学生ID
     * @return 学生对象
     */
    Student getStudentById(Long id);

    /**
     * 查询所有学生
     * @return 学生列表
     */
    List<Student> getAllStudents();

    /**
     * 添加学生
     * @param student 学生对象
     * @return 添加后的学生对象
     */
    Student addStudent(Student student);

    /**
     * 更新学生信息
     * @param student 学生对象
     * @return 更新后的学生对象
     */
    Student updateStudent(Student student);

    /**
     * 删除学生
     * @param id 学生ID
     * @return 是否删除成功
     */
    boolean deleteStudent(Long id);

    /**
     * 根据姓名查询学生
     * @param name 学生姓名
     * @return 学生列表
     */
    List<Student> getStudentsByName(String name);

    /**
     * 根据年龄查询学生
     * @param age 学生年龄
     * @return 学生列表
     */
    List<Student> getStudentsByAge(Integer age);

    /**
     * 根据性别查询学生
     * @param gender 学生性别
     * @return 学生列表
     */
    List<Student> getStudentsByGender(String gender);
}
