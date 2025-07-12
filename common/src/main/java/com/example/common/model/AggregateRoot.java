package com.example.common.model;

import com.example.common.event.DomainEvent;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * 聚合根基类
 */
@Getter
public abstract class AggregateRoot extends BaseEntity {

    /**
     * 未提交的领域事件
     */
    private transient List<DomainEvent> uncomittedEvents = new ArrayList<>();

    /**
     * 添加领域事件
     * @param event 领域事件
     */
    protected void addDomainEvent(DomainEvent event) {
        if (this.uncomittedEvents == null) {
            this.uncomittedEvents = new ArrayList<>();
        }
        this.uncomittedEvents.add(event);
    }

    /**
     * 清除领域事件
     */
    public void clearDomainEvents() {
        if (this.uncomittedEvents != null) {
            this.uncomittedEvents.clear();
        }
    }

    /**
     * 获取未提交的领域事件
     * @return 领域事件列表
     */
    public List<DomainEvent> getUncommittedEvents() {
        return this.uncomittedEvents == null ? new ArrayList<>() : new ArrayList<>(this.uncomittedEvents);
    }

    /**
     * 获取聚合根标识
     * @return 聚合根ID
     */
    public abstract String getAggregateId();
} 