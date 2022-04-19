package com.epead.course.services.impl;

import com.epead.course.models.CourseModel;
import com.epead.course.models.LessonModel;
import com.epead.course.models.ModuleModel;
import com.epead.course.repositories.CourseRepository;
import com.epead.course.repositories.LessonRepository;
import com.epead.course.repositories.ModuleRepository;
import com.epead.course.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    ModuleRepository moduleRepository;

    @Autowired
    LessonRepository lessonRepository;

    @Transactional
    @Override
    public void delete(CourseModel courseModel) {
        List<ModuleModel> moduleModelList = moduleRepository.findAllLModulesIntoCourse(courseModel.getCourseId());
        if (moduleModelList.isEmpty()) {
            for(ModuleModel module : moduleModelList){
                List<LessonModel> lessonModelList = lessonRepository.findAllLessonsIntoModule(module.getModuleID());
                if (!lessonModelList.isEmpty()){
                    lessonRepository.deleteAll(lessonModelList);
                }
            }
            moduleRepository.deleteAll(moduleModelList);
        }
        courseRepository.delete(courseModel);
    }
}
