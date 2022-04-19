package com.epead.course.services.impl;

import com.epead.course.models.LessonModel;
import com.epead.course.models.ModuleModel;
import com.epead.course.repositories.LessonRepository;
import com.epead.course.repositories.ModuleRepository;
import com.epead.course.services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    ModuleRepository moduleRepository;

    @Autowired
    LessonRepository lessonRepository;

    @Transactional
    @Override
    public void delete(ModuleModel moduleModel) {
        List<LessonModel> lessonModelList = lessonRepository.findAllLessonsIntoModule(moduleModel.getModuleID());
        if (!lessonModelList.isEmpty()){
            lessonRepository.deleteAll(lessonModelList);
        }
        moduleRepository.delete(moduleModel);
    }
}
