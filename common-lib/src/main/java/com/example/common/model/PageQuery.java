package com.example.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.Min;
import java.io.Serializable;

/**
 * 分页查询参数
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 默认页码
     */
    public static final int DEFAULT_PAGE_NUMBER = 1;

    /**
     * 默认每页数量
     */
    public static final int DEFAULT_PAGE_SIZE = 10;

    /**
     * 最大每页数量
     */
    public static final int MAX_PAGE_SIZE = 100;

    /**
     * 当前页码
     */
    @Min(value = 1, message = "页码必须大于0")
    private Integer current;

    /**
     * 每页数量
     */
    @Min(value = 1, message = "每页数量必须大于0")
    private Integer size;

    /**
     * 排序字段
     */
    private String orderField;

    /**
     * 排序方式（asc/desc）
     */
    private String orderType;

    /**
     * 获取当前页码
     *
     * @return 当前页码
     */
    public int getCurrent() {
        return current == null || current < 1 ? DEFAULT_PAGE_NUMBER : current;
    }

    /**
     * 获取每页数量
     *
     * @return 每页数量
     */
    public int getSize() {
        if (size == null || size < 1) {
            return DEFAULT_PAGE_SIZE;
        }
        return Math.min(size, MAX_PAGE_SIZE);
    }

    /**
     * 获取排序字段
     *
     * @return 排序字段
     */
    public String getOrderField() {
        return orderField;
    }

    /**
     * 获取排序方式
     *
     * @return 排序方式
     */
    public String getOrderType() {
        if (orderType == null) {
            return "asc";
        }
        return "desc".equalsIgnoreCase(orderType) ? "desc" : "asc";
    }

    /**
     * 是否需要排序
     *
     * @return 是否需要排序
     */
    public boolean needOrder() {
        return orderField != null && !orderField.trim().isEmpty();
    }

    /**
     * 获取偏移量
     *
     * @return 偏移量
     */
    public int getOffset() {
        return (getCurrent() - 1) * getSize();
    }
}
