package com.example.studentManagement.domain.teaching.valueobject;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 课程ID值对象
 */
@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
public class CourseId {

    private final String value;

    /**
     * 创建课程ID
     * @param value 课程ID值
     * @return 课程ID值对象
     */
    public static CourseId of(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("课程ID不能为空");
        }
        return new CourseId(value);
    }

    /**
     * 生成新的课程ID
     * @param prefix 前缀
     * @return 课程ID值对象
     */
    public static CourseId generate(String prefix) {
        String timestamp = String.valueOf(System.currentTimeMillis());
        String id = prefix + timestamp.substring(timestamp.length() - 6);
        return new CourseId(id);
    }

    @Override
    public String toString() {
        return value;
    }
} 