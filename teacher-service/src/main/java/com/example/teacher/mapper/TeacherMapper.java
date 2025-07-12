package com.example.teacher.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.teacher.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 教师数据访问接口
 * @author liujiandong
 */
@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {

    /**
     * 根据教师编号查找教师
     * @param teacherId 教师编号
     * @return 教师对象
     */
    @Select("SELECT * FROM teachers WHERE teacher_id = #{teacherId}")
    Teacher selectByTeacherId(@Param("teacherId") String teacherId);

    /**
     * 根据邮箱查找教师
     * @param email 邮箱
     * @return 教师对象
     */
    @Select("SELECT * FROM teachers WHERE email = #{email}")
    Teacher selectByEmail(@Param("email") String email);

    /**
     * 根据姓名查找教师
     * @param firstName 名
     * @param lastName 姓
     * @return 教师列表
     */
    @Select("SELECT * FROM teachers WHERE first_name = #{firstName} AND last_name = #{lastName}")
    List<Teacher> selectByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    /**
     * 根据姓名模糊查询教师
     * @param name 姓名关键字
     * @return 教师列表
     */
    @Select("SELECT * FROM teachers WHERE first_name LIKE CONCAT('%', #{name}, '%') OR last_name LIKE CONCAT('%', #{name}, '%')")
    List<Teacher> selectByNameContaining(@Param("name") String name);

    /**
     * 根据部门查找教师
     * @param department 部门
     * @return 教师列表
     */
    @Select("SELECT * FROM teachers WHERE department = #{department}")
    List<Teacher> selectByDepartment(@Param("department") String department);

    /**
     * 根据职位查找教师
     * @param position 职位
     * @return 教师列表
     */
    @Select("SELECT * FROM teachers WHERE position = #{position}")
    List<Teacher> selectByPosition(@Param("position") String position);

    /**
     * 根据状态查找教师
     * @param status 状态
     * @return 教师列表
     */
    @Select("SELECT * FROM teachers WHERE status = #{status}")
    List<Teacher> selectByStatus(@Param("status") String status);

    /**
     * 根据薪资范围查找教师
     * @param minSalary 最小薪资
     * @param maxSalary 最大薪资
     * @return 教师列表
     */
    @Select("SELECT * FROM teachers WHERE salary >= #{minSalary} AND salary <= #{maxSalary}")
    List<Teacher> selectBySalaryBetween(@Param("minSalary") Double minSalary, @Param("maxSalary") Double maxSalary);

    /**
     * 根据学历查找教师
     * @param qualification 学历
     * @return 教师列表
     */
    @Select("SELECT * FROM teachers WHERE qualification = #{qualification}")
    List<Teacher> selectByQualification(@Param("qualification") String qualification);

    /**
     * 根据专业查找教师
     * @param specialization 专业
     * @return 教师列表
     */
    @Select("SELECT * FROM teachers WHERE specialization = #{specialization}")
    List<Teacher> selectBySpecialization(@Param("specialization") String specialization);

    /**
     * 检查教师编号是否已存在
     * @param teacherId 教师编号
     * @return 是否存在
     */
    @Select("SELECT COUNT(*) FROM teachers WHERE teacher_id = #{teacherId}")
    int countByTeacherId(@Param("teacherId") String teacherId);

    /**
     * 检查邮箱是否已存在
     * @param email 邮箱
     * @return 是否存在
     */
    @Select("SELECT COUNT(*) FROM teachers WHERE email = #{email}")
    int countByEmail(@Param("email") String email);

    /**
     * 获取部门统计信息
     * @return 部门统计列表
     */
    @Select("SELECT department, COUNT(*) as count FROM teachers GROUP BY department")
    List<Object> getDepartmentStatistics();
} 