package com.epead.course.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class CourseUserDto {

    private UUID courseId;
    private UUID userId;
}
