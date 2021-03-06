package com.epead.course.services.impl;

import com.epead.course.client.AuthUserClient;
import com.epead.course.models.CourseModel;
import com.epead.course.models.CourseUserModel;
import com.epead.course.models.LessonModel;
import com.epead.course.models.ModuleModel;
import com.epead.course.repositories.CourseRepository;
import com.epead.course.repositories.CourseUserRepository;
import com.epead.course.repositories.LessonRepository;
import com.epead.course.repositories.ModuleRepository;
import com.epead.course.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseUserRepository courseUserRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    ModuleRepository moduleRepository;

    @Autowired
    LessonRepository lessonRepository;

    @Autowired
    AuthUserClient authUserClient;

    @Transactional
    @Override
    public void delete(CourseModel courseModel) {

        boolean deleteCourseUserInAuthUser = false;

        List<ModuleModel> moduleModelList = moduleRepository.findAllLModulesIntoCourse(courseModel.getCourseId());
        if (!moduleModelList.isEmpty()) {
            for(ModuleModel module : moduleModelList){
                List<LessonModel> lessonModelList = lessonRepository.findAllLessonsIntoModule(module.getModuleId());
                if (!lessonModelList.isEmpty()){
                    lessonRepository.deleteAll(lessonModelList);
                }
            }
            moduleRepository.deleteAll(moduleModelList);
        }
        List<CourseUserModel> courseUserModelList = courseUserRepository.findAllCourseUserIntoCourse(courseModel.getCourseId());
        if(!courseUserModelList.isEmpty()){
            courseUserRepository.deleteAll(courseUserModelList);
            deleteCourseUserInAuthUser = true;
        }
        courseRepository.delete(courseModel);
        if(deleteCourseUserInAuthUser) {
            authUserClient.deleteCourseInAuthUser(courseModel.getCourseId());
        }
    }

    @Override
    public CourseModel save(CourseModel courseModel) {
        return courseRepository.save(courseModel);
    }

    @Override
    public Optional<CourseModel> findById(UUID courseId) {
        return courseRepository.findById(courseId);
    }

    @Override
    public Page<CourseModel> findAll(Specification<CourseModel> spec, Pageable pageable) {
        return courseRepository.findAll(spec, pageable);
    }

}
