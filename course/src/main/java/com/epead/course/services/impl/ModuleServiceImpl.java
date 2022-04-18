package com.epead.course.services.impl;

import com.epead.course.repositories.ModuleRepository;
import com.epead.course.services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    ModuleRepository moduleRepository;
}
