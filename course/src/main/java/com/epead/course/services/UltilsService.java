package com.epead.course.services;

import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface UltilsService {

    String createUrlGetAllUserByCourse(UUID courseId, Pageable pageable);
}
