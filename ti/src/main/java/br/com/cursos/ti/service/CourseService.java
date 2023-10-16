package br.com.cursos.ti.service;

import br.com.cursos.ti.model.Course;
import br.com.cursos.ti.model.StackEnum;

import java.util.List;

public interface CourseService {

    Course findById(Long id);

    Course findByName(String name);

    List<Course> findByStack(StackEnum stack);

    Course create(Course userToCreate);

    void delete(Long id);

    Course update(Long id, Course user);
}
