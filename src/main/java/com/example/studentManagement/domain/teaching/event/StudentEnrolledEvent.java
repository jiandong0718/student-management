package com.example.studentManagement.domain.teaching.event;

import com.example.studentManagement.common.event.DomainEvent;
import com.example.studentManagement.domain.teaching.entity.Student;
import lombok.Getter;

/**
 * 学生注册事件
 */
@Getter
public class StudentEnrolledEvent extends DomainEvent {

    private final Student student;

    public StudentEnrolledEvent(String aggregateId, Student student) {
        super(aggregateId, student);
        this.student = student;
    }
} 