package com.example.studentManagement.service;

import com.example.studentManagement.entity.Course;
import java.util.List;

/**
 * 课程服务接口
 * @author liujiandong
 */
public interface CourseService {

    /**
     * 根据ID查询课程
     * @param id 课程ID
     * @return 课程对象
     */
    Course getCourseById(Long id);

    /**
     * 查询所有课程
     * @return 课程列表
     */
    List<Course> getAllCourses();

    /**
     * 添加课程
     * @param course 课程对象
     * @return 添加后的课程对象
     */
    Course addCourse(Course course);

    /**
     * 更新课程信息
     * @param course 课程对象
     * @return 更新后的课程对象
     */
    Course updateCourse(Course course);

    /**
     * 删除课程
     * @param id 课程ID
     * @return 是否删除成功
     */
    boolean deleteCourse(Long id);

    /**
     * 根据名称查询课程
     * @param name 课程名称
     * @return 课程列表
     */
    List<Course> getCoursesByName(String name);

    /**
     * 根据教师查询课程
     * @param teacher 教师名称
     * @return 课程列表
     */
    List<Course> getCoursesByTeacher(String teacher);

    /**
     * 根据学分查询课程
     * @param credits 学分
     * @return 课程列表
     */
    List<Course> getCoursesByCredits(Integer credits);
}
