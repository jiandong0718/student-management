package com.example.student.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.student.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 学生数据访问接口
 *
 * @author liujiandong
 */
public interface StudentMapper extends BaseMapper<Student> {

    /**
     * 根据学号查找学生
     *
     * @param studentId 学号
     * @return 学生对象
     */
    @Select("SELECT * FROM students WHERE student_id = #{studentId}")
    Student selectByStudentId(@Param("studentId") String studentId);

    /**
     * 根据邮箱查找学生
     *
     * @param email 邮箱
     * @return 学生对象
     */
    @Select("SELECT * FROM students WHERE email = #{email}")
    Student selectByEmail(@Param("email") String email);

    /**
     * 根据姓名查找学生
     *
     * @param firstName 名
     * @param lastName  姓
     * @return 学生列表
     */
    @Select("SELECT * FROM students WHERE first_name = #{firstName} AND last_name = #{lastName}")
    List<Student> selectByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    /**
     * 根据姓名模糊查询学生
     *
     * @param name 姓名关键字
     * @return 学生列表
     */
    @Select("SELECT * FROM students WHERE first_name LIKE CONCAT('%', #{name}, '%') OR last_name LIKE CONCAT('%', #{name}, '%')")
    List<Student> selectByNameContaining(@Param("name") String name);

    /**
     * 根据专业查找学生
     *
     * @param major 专业
     * @return 学生列表
     */
    @Select("SELECT * FROM students WHERE major = #{major}")
    List<Student> selectByMajor(@Param("major") String major);

    /**
     * 根据状态查找学生
     *
     * @param status 状态
     * @return 学生列表
     */
    @Select("SELECT * FROM students WHERE status = #{status}")
    List<Student> selectByStatus(@Param("status") String status);

    /**
     * 根据GPA范围查找学生
     *
     * @param minGpa 最小GPA
     * @param maxGpa 最大GPA
     * @return 学生列表
     */
    @Select("SELECT * FROM students WHERE gpa >= #{minGpa} AND gpa <= #{maxGpa}")
    List<Student> selectByGpaBetween(@Param("minGpa") Double minGpa, @Param("maxGpa") Double maxGpa);

    /**
     * 检查学号是否已存在
     *
     * @param studentId 学号
     * @return 是否存在
     */
    @Select("SELECT COUNT(*) FROM students WHERE student_id = #{studentId}")
    int countByStudentId(@Param("studentId") String studentId);

    /**
     * 检查邮箱是否已存在
     *
     * @param email 邮箱
     * @return 是否存在
     */
    @Select("SELECT COUNT(*) FROM students WHERE email = #{email}")
    int countByEmail(@Param("email") String email);
} 