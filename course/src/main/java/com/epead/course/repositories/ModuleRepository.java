package com.epead.course.repositories;

import com.epead.course.models.ModuleModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ModuleRepository  extends JpaRepository<ModuleModel, UUID> {

    @Query(value="select * from tb_modules where cource_course_id = :courseId", nativeQuery = true)
    List<ModuleModel> findAllLModulesIntoCourse(@Param("courseId") UUID courseId);
}
