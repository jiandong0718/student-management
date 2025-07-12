package com.example.student.service.impl;

import com.example.student.entity.Student;
import com.example.student.mapper.StudentMapper;
import com.example.student.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 学生服务实现类
 *
 * @author liujiandong
 */
@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student getStudentById(Long id) {
        log.info("查询学生信息，ID: {}", id);
        return studentMapper.selectById(id);
    }

    @Override
    public Student getStudentByStudentId(String studentId) {
        log.info("根据学号查询学生信息，学号: {}", studentId);
        return studentMapper.selectByStudentId(studentId);
    }

    @Override
    public List<Student> getAllStudents() {
        log.info("查询所有学生信息");
        return studentMapper.selectList(null);
    }

    @Override
    @Transactional
    public Student addStudent(Student student) {
        log.info("添加学生信息: {}", student);

        // 检查学号是否已存在
        if (studentMapper.countByStudentId(student.getStudentId()) > 0) {
            throw new RuntimeException("学号已存在: " + student.getStudentId());
        }

        // 检查邮箱是否已存在
        if (studentMapper.countByEmail(student.getEmail()) > 0) {
            throw new RuntimeException("邮箱已存在: " + student.getEmail());
        }

        studentMapper.insert(student);
        return student;
    }

    @Override
    @Transactional
    public Student updateStudent(Student student) {
        log.info("更新学生信息: {}", student);

        // 检查学生是否存在
        Student existingStudent = studentMapper.selectById(student.getId());
        if (existingStudent == null) {
            throw new RuntimeException("学生不存在，ID: " + student.getId());
        }

        // 如果学号发生变化，检查新学号是否已存在
        if (!existingStudent.getStudentId().equals(student.getStudentId())) {
            if (studentMapper.countByStudentId(student.getStudentId()) > 0) {
                throw new RuntimeException("学号已存在: " + student.getStudentId());
            }
        }

        // 如果邮箱发生变化，检查新邮箱是否已存在
        if (!existingStudent.getEmail().equals(student.getEmail())) {
            if (studentMapper.countByEmail(student.getEmail()) > 0) {
                throw new RuntimeException("邮箱已存在: " + student.getEmail());
            }
        }

        studentMapper.updateById(student);
        return student;
    }

    @Override
    @Transactional
    public boolean deleteStudent(Long id) {
        log.info("删除学生信息，ID: {}", id);

        // 检查学生是否存在
        Student existingStudent = studentMapper.selectById(id);
        if (existingStudent == null) {
            throw new RuntimeException("学生不存在，ID: " + id);
        }

        return studentMapper.deleteById(id) > 0;
    }

    @Override
    public List<Student> getStudentsByName(String name) {
        log.info("根据姓名模糊查询学生，姓名: {}", name);
        return studentMapper.selectByNameContaining(name);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        log.info("根据专业查询学生，专业: {}", major);
        return studentMapper.selectByMajor(major);
    }

    @Override
    public List<Student> getStudentsByStatus(String status) {
        log.info("根据状态查询学生，状态: {}", status);
        return studentMapper.selectByStatus(status);
    }

    @Override
    public List<Student> getStudentsByGpaRange(Double minGpa, Double maxGpa) {
        log.info("根据GPA范围查询学生，范围: {} - {}", minGpa, maxGpa);
        return studentMapper.selectByGpaBetween(minGpa, maxGpa);
    }
} 