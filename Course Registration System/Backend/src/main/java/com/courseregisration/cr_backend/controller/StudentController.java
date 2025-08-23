package com.courseregisration.cr_backend.controller;

import com.courseregisration.cr_backend.entity.Student;
import com.courseregisration.cr_backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getAll")
    public List<Student> getAllStudents(){
        return studentService.findAllStudents();
    }

    @GetMapping("{id}")
    public Student getById(@PathVariable("id") int id){
        return studentService.getByID(id);
    }


    @PostMapping("/add")
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @PutMapping("/{id}")
    public String updateStudent(@PathVariable("id") int id, @RequestBody Student student){

       String name= studentService.updateStudent(id,student);
       return name;
    }

    @DeleteMapping("{id}")
    public String deleteById(@PathVariable("id") int id){
        return studentService.deleteById(id);
    }



}
