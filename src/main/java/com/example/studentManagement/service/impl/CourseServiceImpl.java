package com.example.studentManagement.service.impl;

import com.example.studentManagement.entity.Course;
import com.example.studentManagement.mapper.CourseMapper;
import com.example.studentManagement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 课程服务实现类
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public Course getCourseById(Long id) {
        return courseMapper.selectById(id);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseMapper.selectList(null);
    }

    @Override
    @Transactional
    public Course addCourse(Course course) {
        courseMapper.insert(course);
        return course;
    }

    @Override
    @Transactional
    public Course updateCourse(Course course) {
        courseMapper.updateById(course);
        return course;
    }

    @Override
    @Transactional
    public boolean deleteCourse(Long id) {
        return courseMapper.deleteById(id) > 0;
    }

    @Override
    public List<Course> getCoursesByName(String name) {
        return Collections.singletonList(courseMapper.selectByCourseName(name));
    }

    @Override
    public List<Course> getCoursesByTeacher(String teacher) {
        return new ArrayList<>();
    }

    @Override
    public List<Course> getCoursesByCredits(Integer credits) {
        return courseMapper.selectByCreditHours(credits);
    }
}
