package com.example.common.event;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * 领域事件基类
 */
@Data
@NoArgsConstructor
public abstract class DomainEvent {

    /**
     * 事件ID
     */
    private String eventId;

    /**
     * 事件类型
     */
    private String eventType;

    /**
     * 聚合根ID
     */
    private String aggregateId;

    /**
     * 事件发生时间
     */
    private LocalDateTime occurredOn;

    /**
     * 事件版本
     */
    private Integer version;

    /**
     * 事件数据
     */
    private Object data;

    protected DomainEvent(String aggregateId, Object data) {
        this.eventId = UUID.randomUUID().toString();
        this.eventType = this.getClass().getSimpleName();
        this.aggregateId = aggregateId;
        this.occurredOn = LocalDateTime.now();
        this.version = 1;
        this.data = data;
    }

    /**
     * 创建事件
     * @param aggregateId 聚合根ID
     * @param data 事件数据
     * @return 事件实例
     */
    public static DomainEvent create(String aggregateId, Object data) {
        return new DomainEvent(aggregateId, data) {};
    }
} 