package com.example.studentManagement.common.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 统一API响应结果封装
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

    /**
     * 请求是否成功
     */
    private boolean success;

    /**
     * 时间戳
     */
    private long timestamp;

    /**
     * 成功响应
     * @param data 响应数据
     * @param <T> 数据类型
     * @return ApiResponse
     */
    public static <T> ApiResponse<T> success(T data) {
        return ApiResponse.<T>builder()
                .code(ResultCode.SUCCESS.getCode())
                .message(ResultCode.SUCCESS.getMessage())
                .data(data)
                .success(true)
                .timestamp(System.currentTimeMillis())
                .build();
    }

    /**
     * 成功响应
     * @param message 成功消息
     * @param <T> 数据类型
     * @return ApiResponse
     */
    public static <T> ApiResponse<T> success(String message) {
        return ApiResponse.<T>builder()
                .code(ResultCode.SUCCESS.getCode())
                .message(message)
                .success(true)
                .timestamp(System.currentTimeMillis())
                .build();
    }

    /**
     * 成功响应
     * @param data 响应数据
     * @param message 成功消息
     * @param <T> 数据类型
     * @return ApiResponse
     */
    public static <T> ApiResponse<T> success(T data, String message) {
        return ApiResponse.<T>builder()
                .code(ResultCode.SUCCESS.getCode())
                .message(message)
                .data(data)
                .success(true)
                .timestamp(System.currentTimeMillis())
                .build();
    }

    /**
     * 失败响应
     * @param code 错误码
     * @param message 错误消息
     * @param <T> 数据类型
     * @return ApiResponse
     */
    public static <T> ApiResponse<T> error(Integer code, String message) {
        return ApiResponse.<T>builder()
                .code(code)
                .message(message)
                .success(false)
                .timestamp(System.currentTimeMillis())
                .build();
    }

    /**
     * 失败响应
     * @param resultCode 结果码枚举
     * @param <T> 数据类型
     * @return ApiResponse
     */
    public static <T> ApiResponse<T> error(ResultCode resultCode) {
        return error(resultCode.getCode(), resultCode.getMessage());
    }

    /**
     * 失败响应
     * @param resultCode 结果码枚举
     * @param message 自定义错误消息
     * @param <T> 数据类型
     * @return ApiResponse
     */
    public static <T> ApiResponse<T> error(ResultCode resultCode, String message) {
        return error(resultCode.getCode(), message);
    }
} 