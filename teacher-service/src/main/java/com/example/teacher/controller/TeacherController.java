package com.example.teacher.controller;

import com.example.common.response.ApiResponse;
import com.example.teacher.entity.Teacher;
import com.example.teacher.service.TeacherService;
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
 * 教师管理控制器
 *
 * @author liujiandong
 */
@Slf4j
@RestController
@RequestMapping("/api/teachers")
@Validated
@Tag(name = "教师管理", description = "教师信息的增删改查操作")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/{id}")
    @Operation(summary = "根据ID查询教师", description = "根据教师ID查询教师详细信息")
    public ApiResponse<Teacher> getTeacherById(
            @Parameter(description = "教师ID", required = true)
            @PathVariable @NotNull Long id) {
        log.info("接收到查询教师请求，ID: {}", id);
        Teacher teacher = teacherService.getTeacherById(id);
        return ApiResponse.success(teacher);
    }

    @GetMapping("/teacher-id/{teacherId}")
    @Operation(summary = "根据教师编号查询教师", description = "根据教师编号查询教师详细信息")
    public ApiResponse<Teacher> getTeacherByTeacherId(
            @Parameter(description = "教师编号", required = true)
            @PathVariable @NotBlank String teacherId) {
        log.info("接收到根据教师编号查询教师请求，编号: {}", teacherId);
        Teacher teacher = teacherService.getTeacherByTeacherId(teacherId);
        return ApiResponse.success(teacher);
    }

    @GetMapping
    @Operation(summary = "查询所有教师", description = "查询所有教师信息列表")
    public ApiResponse<List<Teacher>> getAllTeachers() {
        log.info("接收到查询所有教师请求");
        List<Teacher> teachers = teacherService.getAllTeachers();
        return ApiResponse.success(teachers);
    }

    @PostMapping
    @Operation(summary = "添加教师", description = "添加新的教师信息")
    public ApiResponse<Teacher> addTeacher(
            @Parameter(description = "教师信息", required = true)
            @RequestBody @Valid Teacher teacher) {
        log.info("接收到添加教师请求: {}", teacher);
        Teacher savedTeacher = teacherService.addTeacher(teacher);
        return ApiResponse.success(savedTeacher, "教师添加成功");
    }

    @PutMapping("/{id}")
    @Operation(summary = "更新教师信息", description = "根据ID更新教师信息")
    public ApiResponse<Teacher> updateTeacher(
            @Parameter(description = "教师ID", required = true)
            @PathVariable @NotNull Long id,
            @Parameter(description = "教师信息", required = true)
            @RequestBody @Valid Teacher teacher) {
        log.info("接收到更新教师请求，ID: {}, 教师信息: {}", id, teacher);
        teacher.setId(id);
        Teacher updatedTeacher = teacherService.updateTeacher(teacher);
        return ApiResponse.success(updatedTeacher, "教师信息更新成功");
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除教师", description = "根据ID删除教师信息")
    public ApiResponse<Boolean> deleteTeacher(
            @Parameter(description = "教师ID", required = true)
            @PathVariable @NotNull Long id) {
        log.info("接收到删除教师请求，ID: {}", id);
        boolean deleted = teacherService.deleteTeacher(id);
        return ApiResponse.success(deleted, "教师删除成功");
    }

    @GetMapping("/search/name")
    @Operation(summary = "根据姓名搜索教师", description = "根据姓名模糊搜索教师")
    public ApiResponse<List<Teacher>> searchTeachersByName(
            @Parameter(description = "姓名关键字", required = true)
            @RequestParam @NotBlank String name) {
        log.info("接收到根据姓名搜索教师请求，姓名: {}", name);
        List<Teacher> teachers = teacherService.getTeachersByName(name);
        return ApiResponse.success(teachers);
    }

    @GetMapping("/search/department")
    @Operation(summary = "根据部门搜索教师", description = "根据部门搜索教师")
    public ApiResponse<List<Teacher>> searchTeachersByDepartment(
            @Parameter(description = "部门", required = true)
            @RequestParam @NotBlank String department) {
        log.info("接收到根据部门搜索教师请求，部门: {}", department);
        List<Teacher> teachers = teacherService.getTeachersByDepartment(department);
        return ApiResponse.success(teachers);
    }

    @GetMapping("/search/position")
    @Operation(summary = "根据职位搜索教师", description = "根据职位搜索教师")
    public ApiResponse<List<Teacher>> searchTeachersByPosition(
            @Parameter(description = "职位", required = true)
            @RequestParam @NotBlank String position) {
        log.info("接收到根据职位搜索教师请求，职位: {}", position);
        List<Teacher> teachers = teacherService.getTeachersByPosition(position);
        return ApiResponse.success(teachers);
    }

    @GetMapping("/search/status")
    @Operation(summary = "根据状态搜索教师", description = "根据状态搜索教师")
    public ApiResponse<List<Teacher>> searchTeachersByStatus(
            @Parameter(description = "状态", required = true)
            @RequestParam @NotBlank String status) {
        log.info("接收到根据状态搜索教师请求，状态: {}", status);
        List<Teacher> teachers = teacherService.getTeachersByStatus(status);
        return ApiResponse.success(teachers);
    }

    @GetMapping("/search/salary")
    @Operation(summary = "根据薪资范围搜索教师", description = "根据薪资范围搜索教师")
    public ApiResponse<List<Teacher>> searchTeachersBySalaryRange(
            @Parameter(description = "最小薪资", required = true)
            @RequestParam @NotNull Double minSalary,
            @Parameter(description = "最大薪资", required = true)
            @RequestParam @NotNull Double maxSalary) {
        log.info("接收到根据薪资范围搜索教师请求，范围: {} - {}", minSalary, maxSalary);
        List<Teacher> teachers = teacherService.getTeachersBySalaryRange(minSalary, maxSalary);
        return ApiResponse.success(teachers);
    }

    @GetMapping("/search/qualification")
    @Operation(summary = "根据学历搜索教师", description = "根据学历搜索教师")
    public ApiResponse<List<Teacher>> searchTeachersByQualification(
            @Parameter(description = "学历", required = true)
            @RequestParam @NotBlank String qualification) {
        log.info("接收到根据学历搜索教师请求，学历: {}", qualification);
        List<Teacher> teachers = teacherService.getTeachersByQualification(qualification);
        return ApiResponse.success(teachers);
    }

    @GetMapping("/search/specialization")
    @Operation(summary = "根据专业搜索教师", description = "根据专业搜索教师")
    public ApiResponse<List<Teacher>> searchTeachersBySpecialization(
            @Parameter(description = "专业", required = true)
            @RequestParam @NotBlank String specialization) {
        log.info("接收到根据专业搜索教师请求，专业: {}", specialization);
        List<Teacher> teachers = teacherService.getTeachersBySpecialization(specialization);
        return ApiResponse.success(teachers);
    }

    @GetMapping("/statistics/department")
    @Operation(summary = "获取部门统计信息", description = "获取各部门教师数量统计")
    public ApiResponse<List<Object>> getDepartmentStatistics() {
        log.info("接收到获取部门统计信息请求");
        List<Object> statistics = teacherService.getDepartmentStatistics();
        return ApiResponse.success(statistics);
    }
} 