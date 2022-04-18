package com.epead.course.services.impl;

import com.epead.course.repositories.CourseRepository;
import com.epead.course.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;
}
