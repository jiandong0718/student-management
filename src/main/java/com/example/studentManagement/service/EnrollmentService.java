package com.example.studentManagement.service;

import com.example.studentManagement.entity.Enrollment;
import java.util.List;

/**
 * 选课服务接口
 * @author liujiandong
 */
public interface EnrollmentService {

    /**
     * 根据ID查询选课记录
     * @param id 选课记录ID
     * @return 选课记录对象
     */
    Enrollment getEnrollmentById(Long id);

    /**
     * 查询所有选课记录
     * @return 选课记录列表
     */
    List<Enrollment> getAllEnrollments();

    /**
     * 添加选课记录
     * @param enrollment 选课记录对象
     * @return 添加后的选课记录对象
     */
    Enrollment addEnrollment(Enrollment enrollment);

    /**
     * 更新选课记录
     * @param enrollment 选课记录对象
     * @return 更新后的选课记录对象
     */
    Enrollment updateEnrollment(Enrollment enrollment);

    /**
     * 删除选课记录
     * @param id 选课记录ID
     * @return 是否删除成功
     */
    boolean deleteEnrollment(Long id);

    /**
     * 根据学生ID查询选课记录
     * @param studentId 学生ID
     * @return 选课记录列表
     */
    List<Enrollment> getEnrollmentsByStudentId(Long studentId);

    /**
     * 根据课程ID查询选课记录
     * @param courseId 课程ID
     * @return 选课记录列表
     */
    List<Enrollment> getEnrollmentsByCourseId(Long courseId);

    /**
     * 根据学生ID和课程ID查询选课记录
     * @param studentId 学生ID
     * @param courseId 课程ID
     * @return 选课记录对象
     */
    Enrollment getEnrollmentByStudentIdAndCourseId(Long studentId, Long courseId);

    /**
     * 根据成绩查询选课记录
     * @param grade 成绩
     * @return 选课记录列表
     */
    List<Enrollment> getEnrollmentsByGrade(Integer grade);
}