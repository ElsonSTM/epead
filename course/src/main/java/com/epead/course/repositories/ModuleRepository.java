package com.epead.course.repositories;

import com.epead.course.models.ModuleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ModuleRepository  extends JpaRepository<ModuleModel, UUID> {
}
