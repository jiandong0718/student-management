package com.example.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * 分页查询结果
 *
 * @param <T> 数据类型
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 当前页码
     */
    private long current;

    /**
     * 每页数量
     */
    private long size;

    /**
     * 总记录数
     */
    private long total;

    /**
     * 总页数
     */
    private long pages;

    /**
     * 数据列表
     */
    private List<T> records;

    /**
     * 是否有上一页
     */
    private boolean hasPrevious;

    /**
     * 是否有下一页
     */
    private boolean hasNext;

    /**
     * 创建空的分页结果
     *
     * @param <T> 数据类型
     * @return 空的分页结果
     */
    public static <T> PageResult<T> empty() {
        return PageResult.<T>builder()
                .current(1)
                .size(10)
                .total(0)
                .pages(0)
                .records(Collections.emptyList())
                .hasPrevious(false)
                .hasNext(false)
                .build();
    }

    /**
     * 创建分页结果
     *
     * @param current  当前页码
     * @param size     每页数量
     * @param total    总记录数
     * @param records  数据列表
     * @param <T>      数据类型
     * @return 分页结果
     */
    public static <T> PageResult<T> of(long current, long size, long total, List<T> records) {
        // 计算总页数
        long pages = total / size;
        if (total % size != 0) {
            pages++;
        }

        // 判断是否有上一页和下一页
        boolean hasPrevious = current > 1;
        boolean hasNext = current < pages;

        return PageResult.<T>builder()
                .current(current)
                .size(size)
                .total(total)
                .pages(pages)
                .records(records)
                .hasPrevious(hasPrevious)
                .hasNext(hasNext)
                .build();
    }
}
