package com.example.teacher.service.impl;

import com.example.teacher.entity.Teacher;
import com.example.teacher.mapper.TeacherMapper;
import com.example.teacher.service.TeacherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 教师服务实现类
 *
 * @author liujiandong
 */
@Slf4j
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Teacher getTeacherById(Long id) {
        log.info("查询教师信息，ID: {}", id);
        return teacherMapper.selectById(id);
    }

    @Override
    public Teacher getTeacherByTeacherId(String teacherId) {
        log.info("根据教师编号查询教师信息，编号: {}", teacherId);
        return teacherMapper.selectByTeacherId(teacherId);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        log.info("查询所有教师信息");
        return teacherMapper.selectList(null);
    }

    @Override
    @Transactional
    public Teacher addTeacher(Teacher teacher) {
        log.info("添加教师信息: {}", teacher);

        // 检查教师编号是否已存在
        if (teacherMapper.countByTeacherId(teacher.getTeacherId()) > 0) {
            throw new RuntimeException("教师编号已存在: " + teacher.getTeacherId());
        }

        // 检查邮箱是否已存在
        if (teacherMapper.countByEmail(teacher.getEmail()) > 0) {
            throw new RuntimeException("邮箱已存在: " + teacher.getEmail());
        }

        teacherMapper.insert(teacher);
        return teacher;
    }

    @Override
    @Transactional
    public Teacher updateTeacher(Teacher teacher) {
        log.info("更新教师信息: {}", teacher);

        // 检查教师是否存在
        Teacher existingTeacher = teacherMapper.selectById(teacher.getId());
        if (existingTeacher == null) {
            throw new RuntimeException("教师不存在，ID: " + teacher.getId());
        }

        teacherMapper.updateById(teacher);
        return teacher;
    }

    @Override
    @Transactional
    public boolean deleteTeacher(Long id) {
        log.info("删除教师信息，ID: {}", id);

        // 检查教师是否存在
        Teacher existingTeacher = teacherMapper.selectById(id);
        if (existingTeacher == null) {
            throw new RuntimeException("教师不存在，ID: " + id);
        }

        return teacherMapper.deleteById(id) > 0;
    }

    @Override
    public List<Teacher> getTeachersByName(String name) {
        log.info("根据姓名模糊查询教师，姓名: {}", name);
        return teacherMapper.selectByNameContaining(name);
    }

    @Override
    public List<Teacher> getTeachersByDepartment(String department) {
        log.info("根据部门查询教师，部门: {}", department);
        return teacherMapper.selectByDepartment(department);
    }

    @Override
    public List<Teacher> getTeachersByPosition(String position) {
        log.info("根据职位查询教师，职位: {}", position);
        return teacherMapper.selectByPosition(position);
    }

    @Override
    public List<Teacher> getTeachersByStatus(String status) {
        log.info("根据状态查询教师，状态: {}", status);
        return teacherMapper.selectByStatus(status);
    }

    @Override
    public List<Teacher> getTeachersBySalaryRange(Double minSalary, Double maxSalary) {
        log.info("根据薪资范围查询教师，范围: {} - {}", minSalary, maxSalary);
        return teacherMapper.selectBySalaryBetween(minSalary, maxSalary);
    }

    @Override
    public List<Teacher> getTeachersByQualification(String qualification) {
        log.info("根据学历查询教师，学历: {}", qualification);
        return teacherMapper.selectByQualification(qualification);
    }

    @Override
    public List<Teacher> getTeachersBySpecialization(String specialization) {
        log.info("根据专业查询教师，专业: {}", specialization);
        return teacherMapper.selectBySpecialization(specialization);
    }

    @Override
    public List<Object> getDepartmentStatistics() {
        log.info("获取部门统计信息");
        return teacherMapper.getDepartmentStatistics();
    }
} 