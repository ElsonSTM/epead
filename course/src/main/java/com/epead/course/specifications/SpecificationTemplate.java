package com.epead.course.specifications;

import com.epead.course.models.CourseModel;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

public class SpecificationTemplate {

    @And({ //notação para combinar filtros abaixo
            @Spec(path = "courseLevel", spec = Equal.class),
            @Spec(path = "courceStatus", spec = Equal.class),
            @Spec(path = "name", spec = Like.class),
    })
    public interface CourseSpec extends Specification<CourseModel> {}
}

