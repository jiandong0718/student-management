package com.example.studentManagement.common.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * 领域事件发布器
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class DomainEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    /**
     * 发布本地事件（同步）
     * @param event 领域事件
     */
    public void publishLocal(DomainEvent event) {
        log.info("Publishing local event: {}", event.getEventType());
        applicationEventPublisher.publishEvent(event);
    }

    /**
     * 发布远程事件（异步）
     * @param event 领域事件
     */
    public void publishRemote(DomainEvent event) {
        log.info("Publishing remote event: {} to topic: {}", event.getEventType(), getTopicName(event));
        kafkaTemplate.send(getTopicName(event), event.getAggregateId(), event);
    }

    /**
     * 发布事件（本地+远程）
     * @param event 领域事件
     */
    public void publishAll(DomainEvent event) {
        publishLocal(event);
        publishRemote(event);
    }

    /**
     * 获取主题名称
     * @param event 领域事件
     * @return 主题名称
     */
    private String getTopicName(DomainEvent event) {
        return "domain-events-" + event.getEventType().toLowerCase();
    }
} 