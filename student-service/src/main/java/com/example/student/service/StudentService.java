package com.example.student.service;

import com.example.student.entity.Student;
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
     * 根据学号查询学生
     * @param studentId 学号
     * @return 学生对象
     */
    Student getStudentByStudentId(String studentId);

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
     * 根据专业查询学生
     * @param major 专业
     * @return 学生列表
     */
    List<Student> getStudentsByMajor(String major);

    /**
     * 根据状态查询学生
     * @param status 状态
     * @return 学生列表
     */
    List<Student> getStudentsByStatus(String status);

    /**
     * 根据GPA范围查询学生
     * @param minGpa 最小GPA
     * @param maxGpa 最大GPA
     * @return 学生列表
     */
    List<Student> getStudentsByGpaRange(Double minGpa, Double maxGpa);
} 