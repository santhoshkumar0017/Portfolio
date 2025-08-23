package com.courseregisration.cr_backend.controller;


import com.courseregisration.cr_backend.entity.Course;
import com.courseregisration.cr_backend.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CourseController {

    @Autowired
    private CourseService courseService;


    @PostMapping("course-add")
    public String addCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }

    @GetMapping("course-getAll")
    public List<Course> getAllCourse(){
        return courseService.getAllCourse();
    }

    @PutMapping("course-update/{id}")
    public String updateCourse(@PathVariable ("id") Long id, @RequestBody Course course){
        return courseService.updateCourse(id,course);
    }

    @GetMapping("course-get/{id}")
    public Course getCourseById(@PathVariable ("id") Long id){
        return courseService.getCourseById(id);
    }
}
