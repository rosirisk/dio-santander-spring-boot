package br.com.cursos.ti.service.impl;


import br.com.cursos.ti.model.StackEnum;
import br.com.cursos.ti.model.Course;
import br.com.cursos.ti.repository.CourseRepository;
import br.com.cursos.ti.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repository;

    public CourseServiceImpl(CourseRepository repository) {
        this.repository = repository;
    }

    @Override
    public Course findById(Long id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Course findByName(String name) {
        return repository.findByName(name).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Course> findByStack(StackEnum stack) {
        return repository.findAllByStack(stack);
    }

    @Override
    public Course create(Course course) {
        if (repository.existsByName(course.getName())) {
            throw new IllegalArgumentException("This name already exists.");
        }
        return repository.save(course);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Course update(Long id, Course course) {
        Optional<Course> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new IllegalArgumentException("Courses not exists.");
        }
        course.setId(id);
        repository.save(course);
        return course;
    }
}
