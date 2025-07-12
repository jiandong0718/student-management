package com.example.studentManagement.domain.teaching.event;

import com.example.studentManagement.common.event.DomainEvent;
import com.example.studentManagement.domain.teaching.entity.Student;
import lombok.Getter;

/**
 * 学生信息更新事件
 */
@Getter
public class StudentUpdatedEvent extends DomainEvent {

    private final Student student;

    public StudentUpdatedEvent(String aggregateId, Student student) {
        super(aggregateId, student);
        this.student = student;
    }
} 