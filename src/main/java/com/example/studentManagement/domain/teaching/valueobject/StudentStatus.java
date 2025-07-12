package com.example.studentManagement.domain.teaching.valueobject;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 学生状态枚举
 */
@Getter
@AllArgsConstructor
public enum StudentStatus {

    /**
     * 在读
     */
    ACTIVE("ACTIVE", "在读"),

    /**
     * 休学
     */
    SUSPENDED("SUSPENDED", "休学"),

    /**
     * 毕业
     */
    GRADUATED("GRADUATED", "毕业"),

    /**
     * 退学
     */
    WITHDRAWN("WITHDRAWN", "退学"),

    /**
     * 转学
     */
    TRANSFERRED("TRANSFERRED", "转学");

    private final String value;
    private final String description;

    /**
     * 根据值获取状态
     * @param value 状态值
     * @return 学生状态
     */
    public static StudentStatus fromValue(String value) {
        for (StudentStatus status : StudentStatus.values()) {
            if (status.getValue().equals(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("未知的学生状态: " + value);
    }

    /**
     * 是否为活跃状态
     * @return 是否活跃
     */
    public boolean isActive() {
        return this == ACTIVE;
    }
} 