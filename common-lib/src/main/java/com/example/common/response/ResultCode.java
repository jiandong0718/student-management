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

    // 数据库错误 2000~2999
    DB_ERROR(2000, "数据库操作异常"),
    DATA_INTEGRITY_ERROR(2001, "数据完整性异常"),

    // 文件操作错误 3000~3999
    FILE_UPLOAD_ERROR(3000, "文件上传失败"),
    FILE_DOWNLOAD_ERROR(3001, "文件下载失败"),
    FILE_NOT_FOUND(3002, "文件不存在"),

    // 第三方服务错误 4000~4999
    THIRD_PARTY_SERVICE_ERROR(4000, "第三方服务调用失败"),

    // 未知错误
    UNKNOWN_ERROR(9999, "未知错误");

    private final Integer code;
    private final String message;
}
