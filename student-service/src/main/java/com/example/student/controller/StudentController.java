package com.example.student.controller;

import com.example.common.response.ApiResponse;
import com.example.student.entity.Student;
import com.example.student.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 学生管理控制器
 * @author liujiandong
 */
@Slf4j
@RestController
@RequestMapping("/api/students")
@Validated
@Tag(name = "学生管理", description = "学生信息的增删改查操作")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    @Operation(summary = "根据ID查询学生", description = "根据学生ID查询学生详细信息")
    public ApiResponse<Student> getStudentById(
            @Parameter(description = "学生ID", required = true)
            @PathVariable @NotNull Long id) {
        log.info("接收到查询学生请求，ID: {}", id);
        Student student = studentService.getStudentById(id);
        return ApiResponse.success(student);
    }

    @GetMapping("/student-id/{studentId}")
    @Operation(summary = "根据学号查询学生", description = "根据学号查询学生详细信息")
    public ApiResponse<Student> getStudentByStudentId(
            @Parameter(description = "学号", required = true)
            @PathVariable @NotBlank String studentId) {
        log.info("接收到根据学号查询学生请求，学号: {}", studentId);
        Student student = studentService.getStudentByStudentId(studentId);
        return ApiResponse.success(student);
    }

    @GetMapping
    @Operation(summary = "查询所有学生", description = "查询所有学生信息列表")
    public ApiResponse<List<Student>> getAllStudents() {
        log.info("接收到查询所有学生请求");
        List<Student> students = studentService.getAllStudents();
        return ApiResponse.success(students);
    }

    @PostMapping
    @Operation(summary = "添加学生", description = "添加新的学生信息")
    public ApiResponse<Student> addStudent(
            @Parameter(description = "学生信息", required = true)
            @RequestBody @Valid Student student) {
        log.info("接收到添加学生请求: {}", student);
        Student savedStudent = studentService.addStudent(student);
        return ApiResponse.success(savedStudent, "学生添加成功");
    }

    @PutMapping("/{id}")
    @Operation(summary = "更新学生信息", description = "根据ID更新学生信息")
    public ApiResponse<Student> updateStudent(
            @Parameter(description = "学生ID", required = true)
            @PathVariable @NotNull Long id,
            @Parameter(description = "学生信息", required = true)
            @RequestBody @Valid Student student) {
        log.info("接收到更新学生请求，ID: {}, 学生信息: {}", id, student);
        student.setId(id);
        Student updatedStudent = studentService.updateStudent(student);
        return ApiResponse.success(updatedStudent, "学生信息更新成功");
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除学生", description = "根据ID删除学生信息")
    public ApiResponse<Boolean> deleteStudent(
            @Parameter(description = "学生ID", required = true)
            @PathVariable @NotNull Long id) {
        log.info("接收到删除学生请求，ID: {}", id);
        boolean deleted = studentService.deleteStudent(id);
        return ApiResponse.success(deleted, "学生删除成功");
    }

    @GetMapping("/search/name")
    @Operation(summary = "根据姓名搜索学生", description = "根据姓名模糊搜索学生")
    public ApiResponse<List<Student>> searchStudentsByName(
            @Parameter(description = "姓名关键字", required = true)
            @RequestParam @NotBlank String name) {
        log.info("接收到根据姓名搜索学生请求，姓名: {}", name);
        List<Student> students = studentService.getStudentsByName(name);
        return ApiResponse.success(students);
    }

    @GetMapping("/search/major")
    @Operation(summary = "根据专业搜索学生", description = "根据专业搜索学生")
    public ApiResponse<List<Student>> searchStudentsByMajor(
            @Parameter(description = "专业", required = true)
            @RequestParam @NotBlank String major) {
        log.info("接收到根据专业搜索学生请求，专业: {}", major);
        List<Student> students = studentService.getStudentsByMajor(major);
        return ApiResponse.success(students);
    }

    @GetMapping("/search/status")
    @Operation(summary = "根据状态搜索学生", description = "根据状态搜索学生")
    public ApiResponse<List<Student>> searchStudentsByStatus(
            @Parameter(description = "状态", required = true)
            @RequestParam @NotBlank String status) {
        log.info("接收到根据状态搜索学生请求，状态: {}", status);
        List<Student> students = studentService.getStudentsByStatus(status);
        return ApiResponse.success(students);
    }

    @GetMapping("/search/gpa")
    @Operation(summary = "根据GPA范围搜索学生", description = "根据GPA范围搜索学生")
    public ApiResponse<List<Student>> searchStudentsByGpaRange(
            @Parameter(description = "最小GPA", required = true)
            @RequestParam @NotNull Double minGpa,
            @Parameter(description = "最大GPA", required = true)
            @RequestParam @NotNull Double maxGpa) {
        log.info("接收到根据GPA范围搜索学生请求，范围: {} - {}", minGpa, maxGpa);
        List<Student> students = studentService.getStudentsByGpaRange(minGpa, maxGpa);
        return ApiResponse.success(students);
    }
} 