package com.example.studentManagement.domain.teaching.valueobject;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 学生ID值对象
 */
@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
public class StudentId {

    private final String value;

    /**
     * 创建学生ID
     * @param value 学生ID值
     * @return 学生ID值对象
     */
    public static StudentId of(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("学生ID不能为空");
        }
        return new StudentId(value);
    }

    /**
     * 生成新的学生ID
     * @param prefix 前缀
     * @return 学生ID值对象
     */
    public static StudentId generate(String prefix) {
        String timestamp = String.valueOf(System.currentTimeMillis());
        String id = prefix + timestamp.substring(timestamp.length() - 8);
        return new StudentId(id);
    }

    @Override
    public String toString() {
        return value;
    }
} 