package com.epead.authu.services.impl;

import com.epead.authu.repositories.UserCourseRepository;
import com.epead.authu.services.UserCourseService;
import org.springframework.stereotype.Service;

@Service
public class UserCourseServiceImpl  implements UserCourseService {

    final
    UserCourseRepository userCourseRepository;

    public UserCourseServiceImpl(UserCourseRepository userCourseRepository) {
        this.userCourseRepository = userCourseRepository;
    }
}
