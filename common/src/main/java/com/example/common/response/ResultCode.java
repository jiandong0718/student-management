package com.example.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * API响应状态码枚举
 */
@Getter
@AllArgsConstructor
public enum ResultCode {

    // 成功
    SUCCESS(200, "操作成功"),

    // 客户端错误 4xx
    BAD_REQUEST(400, "请求参数错误"),
    UNAUTHORIZED(401, "未授权访问"),
    FORBIDDEN(403, "禁止访问"),
    NOT_FOUND(404, "资源不存在"),
    METHOD_NOT_ALLOWED(405, "请求方法不允许"),
    CONFLICT(409, "资源冲突"),

    // 服务端错误 5xx
    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),
    SERVICE_UNAVAILABLE(503, "服务不可用"),

    // 业务错误 1000~9999
    PARAM_MISSING(1000, "缺少必要参数"),
    PARAM_INVALID(1001, "参数格式不正确"),
    USER_NOT_FOUND(1002, "用户不存在"),
    USER_ALREADY_EXISTS(1003, "用户已存在"),
    PASSWORD_ERROR(1004, "密码错误"),
    ACCOUNT_LOCKED(1005, "账号已锁定"),

    // 学生管理错误 2000~2999
    STUDENT_NOT_FOUND(2000, "学生不存在"),
    STUDENT_ALREADY_EXISTS(2001, "学生已存在"),
    STUDENT_ENROLLMENT_FAILED(2002, "学生注册失败"),
    
    // 教师管理错误 3000~3999
    TEACHER_NOT_FOUND(3000, "教师不存在"),
    TEACHER_ALREADY_EXISTS(3001, "教师已存在"),
    
    // 课程管理错误 4000~4999
    COURSE_NOT_FOUND(4000, "课程不存在"),
    COURSE_ALREADY_EXISTS(4001, "课程已存在"),
    COURSE_FULL(4002, "课程已满"),
    COURSE_NOT_AVAILABLE(4003, "课程不可用"),
    
    // 选课管理错误 5000~5999
    ENROLLMENT_NOT_FOUND(5000, "选课记录不存在"),
    ENROLLMENT_ALREADY_EXISTS(5001, "学生已选择该课程"),
    ENROLLMENT_NOT_ALLOWED(5002, "不允许选择该课程"),

    // 数据库错误 6000~6999
    DB_ERROR(6000, "数据库操作异常"),
    DATA_INTEGRITY_ERROR(6001, "数据完整性异常"),

    // 文件操作错误 7000~7999
    FILE_UPLOAD_ERROR(7000, "文件上传失败"),
    FILE_DOWNLOAD_ERROR(7001, "文件下载失败"),
    FILE_NOT_FOUND(7002, "文件不存在"),

    // 第三方服务错误 8000~8999
    THIRD_PARTY_SERVICE_ERROR(8000, "第三方服务调用失败"),

    // 未知错误
    UNKNOWN_ERROR(9999, "未知错误");

    private final Integer code;
    private final String message;
} 