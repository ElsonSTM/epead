package com.epead.authu.dtos;

import com.epead.authu.enums.CourseLevel;
import com.epead.authu.enums.CourseStatus;
import lombok.Data;

import java.util.UUID;

@Data
public class CourseDto {

    private UUID courseId;
    private String name;
    private String description;
    private String imageUrl;
    private CourseStatus courseStatus;
    private UUID userInstructor;
    private CourseLevel courseLevel;
}
