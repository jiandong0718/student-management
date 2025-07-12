package com.example.studentManagement.domain.teaching.event;

import com.example.studentManagement.common.event.DomainEvent;
import com.example.studentManagement.domain.teaching.entity.Course;
import lombok.Getter;

/**
 * 课程创建事件
 */
@Getter
public class CourseCreatedEvent extends DomainEvent {

    private final Course course;

    public CourseCreatedEvent(String aggregateId, Course course) {
        super(aggregateId, course);
        this.course = course;
    }
} 