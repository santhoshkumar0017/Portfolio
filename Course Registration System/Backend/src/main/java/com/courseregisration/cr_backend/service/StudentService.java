package com.courseregisration.cr_backend.service;

import com.courseregisration.cr_backend.entity.Student;
import com.courseregisration.cr_backend.exception.ResourcesNotFoundException;
import com.courseregisration.cr_backend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public  List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public String updateStudent(int id, Student student) {
      Student student2=studentRepository.findById(id).orElseThrow( () ->
              new ResourcesNotFoundException("Student is not existing with given id"+id));

                student2.setFirstName(student.getFirstName());
                student2.setLastName(student.getLastName());
                student2.setEmail(student.getEmail());
                student2.setCourseName(student.getCourseName());

     studentRepository.save(student2);
     return "Update Successfully";
    }

    public Student getByID(int id) {

        Student student= studentRepository.findById(id).orElseThrow(() ->
                new ResourcesNotFoundException("Student is not existing with given id"+id));
        return student;

    }

    public String deleteById(int id) {
        Student student= studentRepository.findById(id).orElseThrow(() ->
                new ResourcesNotFoundException("Student is not existing with given id"+id));
        studentRepository.deleteById(student.getId());
        return "Deleted Successfully";
    }
}
