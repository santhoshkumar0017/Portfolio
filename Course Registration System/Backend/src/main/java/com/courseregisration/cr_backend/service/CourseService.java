package com.courseregisration.cr_backend.service;

import com.courseregisration.cr_backend.entity.Course;
import com.courseregisration.cr_backend.exception.ResourcesNotFoundException;
import com.courseregisration.cr_backend.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public String addCourse(Course course) {
        courseRepository.save(course);
        return "Course Added";
    }


    public List<Course> getAllCourse() {
      return  courseRepository.findAll();
    }

    public String updateCourse(Long id, Course course) {
        Course c=courseRepository.findById(id).orElseThrow(()
                -> new ResourcesNotFoundException("Course not is found id:"+id));
        c.setCourseName(course.getCourseName());
        c.setTrainerName(course.getTrainerName());
        c.setDuration(course.getDuration());
        c.setUrlImg(course.getUrlImg());
        courseRepository.save(c);
        return "Update Successfully";

    }

    public Course getCourseById(Long id) {
        Course course =courseRepository.findById(id).orElseThrow(()
                ->new ResourcesNotFoundException("Course not is found id:"+id));

        return course;
    }
}
