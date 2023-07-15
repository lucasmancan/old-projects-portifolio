package br.com.lucasmancan.course.controllers;

import br.com.lucasmancan.core.models.Course;
import br.com.lucasmancan.core.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("v1/course")
public class CourseController {

    private CourseRepository repository;

    @Autowired
    public CourseController(CourseRepository repository){
        this.repository = repository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Iterable<Course>> list(Pageable pageable){
        return new ResponseEntity<>(repository.findAll(pageable), HttpStatus.OK);
    }

}
