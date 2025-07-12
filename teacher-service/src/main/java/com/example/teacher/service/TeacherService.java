package com.example.teacher.service;

import com.example.teacher.entity.Teacher;
import java.util.List;

/**
 * 教师服务接口
 * @author liujiandong
 */
public interface TeacherService {

    /**
     * 根据ID查询教师
     * @param id 教师ID
     * @return 教师对象
     */
    Teacher getTeacherById(Long id);

    /**
     * 根据教师编号查询教师
     * @param teacherId 教师编号
     * @return 教师对象
     */
    Teacher getTeacherByTeacherId(String teacherId);

    /**
     * 查询所有教师
     * @return 教师列表
     */
    List<Teacher> getAllTeachers();

    /**
     * 添加教师
     * @param teacher 教师对象
     * @return 添加后的教师对象
     */
    Teacher addTeacher(Teacher teacher);

    /**
     * 更新教师信息
     * @param teacher 教师对象
     * @return 更新后的教师对象
     */
    Teacher updateTeacher(Teacher teacher);

    /**
     * 删除教师
     * @param id 教师ID
     * @return 是否删除成功
     */
    boolean deleteTeacher(Long id);

    /**
     * 根据姓名查询教师
     * @param name 教师姓名
     * @return 教师列表
     */
    List<Teacher> getTeachersByName(String name);

    /**
     * 根据部门查询教师
     * @param department 部门
     * @return 教师列表
     */
    List<Teacher> getTeachersByDepartment(String department);

    /**
     * 根据职位查询教师
     * @param position 职位
     * @return 教师列表
     */
    List<Teacher> getTeachersByPosition(String position);

    /**
     * 根据状态查询教师
     * @param status 状态
     * @return 教师列表
     */
    List<Teacher> getTeachersByStatus(String status);

    /**
     * 根据薪资范围查询教师
     * @param minSalary 最小薪资
     * @param maxSalary 最大薪资
     * @return 教师列表
     */
    List<Teacher> getTeachersBySalaryRange(Double minSalary, Double maxSalary);

    /**
     * 根据学历查询教师
     * @param qualification 学历
     * @return 教师列表
     */
    List<Teacher> getTeachersByQualification(String qualification);

    /**
     * 根据专业查询教师
     * @param specialization 专业
     * @return 教师列表
     */
    List<Teacher> getTeachersBySpecialization(String specialization);

    /**
     * 获取部门统计信息
     * @return 部门统计列表
     */
    List<Object> getDepartmentStatistics();
} 