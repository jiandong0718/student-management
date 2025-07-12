package com.example.studentManagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.studentManagement.entity.Enrollment;
import com.example.studentManagement.entity.Student;
import com.example.studentManagement.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/**
 * 选课记录数据访问接口
 * @author liujiandong
 */
@Mapper
public interface EnrollmentMapper extends BaseMapper<Enrollment> {

    /**
     * 根据学生ID查找选课记录
     * @param studentId 学生ID
     * @return 选课记录列表
     */
    @Select("SELECT * FROM enrollments WHERE student_id = #{studentId}")
    List<Enrollment> selectByStudentId(@Param("studentId") Long studentId);

    /**
     * 根据课程ID查找选课记录
     * @param courseId 课程ID
     * @return 选课记录列表
     */
    @Select("SELECT * FROM enrollments WHERE course_id = #{courseId}")
    List<Enrollment> selectByCourseId(@Param("courseId") Long courseId);

    /**
     * 根据学生ID和课程ID查找选课记录
     * @param studentId 学生ID
     * @param courseId 课程ID
     * @return 选课记录
     */
    @Select("SELECT * FROM enrollments WHERE student_id = #{studentId} AND course_id = #{courseId}")
    Enrollment selectByStudentIdAndCourseId(@Param("studentId") Long studentId, @Param("courseId") Long courseId);

    /**
     * 根据成绩范围查找选课记录
     * @param minGrade 最低成绩
     * @param maxGrade 最高成绩
     * @return 选课记录列表
     */
    @Select("SELECT * FROM enrollments WHERE grade >= #{minGrade} AND grade <= #{maxGrade}")
    List<Enrollment> selectByGradeBetween(@Param("minGrade") Double minGrade, @Param("maxGrade") Double maxGrade);

    /**
     * 根据选课状态查找选课记录
     * @param status 选课状态
     * @return 选课记录列表
     */
    @Select("SELECT * FROM enrollments WHERE status = #{status}")
    List<Enrollment> selectByStatus(@Param("status") String status);

    /**
     * 根据选课日期范围查找选课记录
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return 选课记录列表
     */
    @Select("SELECT * FROM enrollments WHERE enrollment_date BETWEEN #{startDate} AND #{endDate}")
    List<Enrollment> selectByEnrollmentDateBetween(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    /**
     * 根据学期查找选课记录
     * @param semester 学期
     * @return 选课记录列表
     */
    @Select("SELECT * FROM enrollments WHERE semester = #{semester}")
    List<Enrollment> selectBySemester(@Param("semester") String semester);

    /**
     * 根据年份查找选课记录
     * @param year 年份
     * @return 选课记录列表
     */
    @Select("SELECT * FROM enrollments WHERE year = #{year}")
    List<Enrollment> selectByYear(@Param("year") Integer year);

    /**
     * 根据学期和年份查找选课记录
     * @param semester 学期
     * @param year 年份
     * @return 选课记录列表
     */
    @Select("SELECT * FROM enrollments WHERE semester = #{semester} AND year = #{year}")
    List<Enrollment> selectBySemesterAndYear(@Param("semester") String semester, @Param("year") Integer year);

    /**
     * 查询某学生的所有课程
     * @param studentId 学生ID
     * @return 课程列表
     */
    @Select("SELECT c.* FROM courses c JOIN enrollments e ON c.id = e.course_id WHERE e.student_id = #{studentId}")
    List<Course> selectCoursesByStudentId(@Param("studentId") Long studentId);

    /**
     * 查询某课程的所有学生
     * @param courseId 课程ID
     * @return 学生列表
     */
    @Select("SELECT s.* FROM students s JOIN enrollments e ON s.id = e.student_id WHERE e.course_id = #{courseId}")
    List<Student> selectStudentsByCourseId(@Param("courseId") Long courseId);

    /**
     * 统计某课程的选课人数
     * @param courseId 课程ID
     * @return 选课人数
     */
    @Select("SELECT COUNT(*) FROM enrollments WHERE course_id = #{courseId}")
    int countByCourseId(@Param("courseId") Long courseId);

    /**
     * 统计某学生的选课数量
     * @param studentId 学生ID
     * @return 选课数量
     */
    @Select("SELECT COUNT(*) FROM enrollments WHERE student_id = #{studentId}")
    int countByStudentId(@Param("studentId") Long studentId);
}
