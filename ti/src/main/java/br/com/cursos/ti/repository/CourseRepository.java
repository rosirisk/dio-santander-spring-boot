package br.com.cursos.ti.repository;


import br.com.cursos.ti.model.Course;
import br.com.cursos.ti.model.StackEnum;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
    List<Course> findAllByStack(StackEnum stack);
    Optional<Course> findByName(String name);

    boolean existsByName(String name);
}
