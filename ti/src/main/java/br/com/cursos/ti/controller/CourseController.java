package br.com.cursos.ti.controller;


import br.com.cursos.ti.model.StackEnum;
import br.com.cursos.ti.model.Course;
import br.com.cursos.ti.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> findById(@PathVariable Long id) {
       var course = service.findById(id);
       return ResponseEntity.ok(course);
    }
    @PostMapping
    public ResponseEntity<Course> create(@RequestBody Course courseToCreate) {
        var courseCreated = service.create(courseToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(courseCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(courseCreated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().body(null);
    }
    @PutMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id,@RequestBody Course courseToUpdate ) {
        Course courseUpdated = service.update(id, courseToUpdate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(courseUpdated.getId())
                .toUri();
        return ResponseEntity.created(location).body(courseUpdated);
    }
}
