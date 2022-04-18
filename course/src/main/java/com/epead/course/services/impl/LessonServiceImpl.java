package com.epead.course.services.impl;

import com.epead.course.repositories.LessonRepository;
import com.epead.course.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonServiceImpl implements LessonService {

    @Autowired
    LessonRepository lessonRepository;
}
