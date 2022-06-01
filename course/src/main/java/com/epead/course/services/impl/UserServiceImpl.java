package com.epead.course.services.impl;

import com.epead.course.repositories.UserRepository;
import com.epead.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
}
