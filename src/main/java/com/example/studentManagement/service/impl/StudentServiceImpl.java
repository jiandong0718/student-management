package com.example.studentManagement.service.impl;

import com.example.studentManagement.entity.Student;
import com.example.studentManagement.mapper.StudentMapper;
import com.example.studentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 学生服务实现类
 * @author liujiandong
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student getStudentById(Long id) {
        return studentMapper.selectById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentMapper.selectList(null);
    }

    @Override
    @Transactional
    public Student addStudent(Student student) {
        studentMapper.insert(student);
        return student;
    }

    @Override
    @Transactional
    public Student updateStudent(Student student) {
        studentMapper.updateById(student);
        return student;
    }

    @Override
    @Transactional
    public boolean deleteStudent(Long id) {
        return studentMapper.deleteById(id) > 0;
    }

    @Override
    public List<Student> getStudentsByName(String name) {
        return studentMapper.selectByFirstNameAndLastName("", "");
    }

    @Override
    public List<Student> getStudentsByAge(Integer age) {
        return new ArrayList<>();
    }

    @Override
    public List<Student> getStudentsByGender(String gender) {
        return new ArrayList<>();
    }
}
