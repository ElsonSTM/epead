package com.epead.authu.services;

import com.epead.authu.models.UserCourseModel;
import com.epead.authu.models.UserModel;

import java.util.UUID;

public interface UserCourseService {
    boolean existByUserAndCourseId(UserModel userModel, UUID courseId);

    UserCourseModel save(UserCourseModel userCourseModel);
}
