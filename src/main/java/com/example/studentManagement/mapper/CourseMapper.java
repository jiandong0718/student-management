package com.example.studentManagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.studentManagement.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 课程数据访问接口
 * @author liujiandong
 */
@Mapper
public interface CourseMapper extends BaseMapper<Course> {

    /**
     * 根据课程代码查找课程
     * @param courseCode 课程代码
     * @return 课程对象
     */
    @Select("SELECT * FROM courses WHERE course_code = #{courseCode}")
    Course selectByCourseCode(@Param("courseCode") String courseCode);

    /**
     * 根据课程名称查找课程
     * @param courseName 课程名称
     * @return 课程对象
     */
    @Select("SELECT * FROM courses WHERE course_name = #{courseName}")
    Course selectByCourseName(@Param("courseName") String courseName);

    /**
     * 根据课程名称模糊查询课程
     * @param courseName 课程名称关键字
     * @return 课程列表
     */
    @Select("SELECT * FROM courses WHERE course_name LIKE CONCAT('%', #{courseName}, '%')")
    List<Course> selectByCourseNameContaining(@Param("courseName") String courseName);

    /**
     * 根据学分查找课程
     * @param creditHours 学分
     * @return 课程列表
     */
    @Select("SELECT * FROM courses WHERE credit_hours = #{creditHours}")
    List<Course> selectByCreditHours(@Param("creditHours") Integer creditHours);

    /**
     * 根据学期查找课程
     * @param semester 学期
     * @return 课程列表
     */
    @Select("SELECT * FROM courses WHERE semester = #{semester}")
    List<Course> selectBySemester(@Param("semester") String semester);

    /**
     * 根据年份查找课程
     * @param year 年份
     * @return 课程列表
     */
    @Select("SELECT * FROM courses WHERE year = #{year}")
    List<Course> selectByYear(@Param("year") Integer year);

    /**
     * 根据学期和年份查找课程
     * @param semester 学期
     * @param year 年份
     * @return 课程列表
     */
    @Select("SELECT * FROM courses WHERE semester = #{semester} AND year = #{year}")
    List<Course> selectBySemesterAndYear(@Param("semester") String semester, @Param("year") Integer year);

    /**
     * 根据部门查找课程
     * @param department 部门
     * @return 课程列表
     */
    @Select("SELECT * FROM courses WHERE department = #{department}")
    List<Course> selectByDepartment(@Param("department") String department);

    /**
     * 检查课程代码是否已存在
     * @param courseCode 课程代码
     * @return 是否存在
     */
    @Select("SELECT COUNT(*) FROM courses WHERE course_code = #{courseCode}")
    int countByCourseCode(@Param("courseCode") String courseCode);
}
