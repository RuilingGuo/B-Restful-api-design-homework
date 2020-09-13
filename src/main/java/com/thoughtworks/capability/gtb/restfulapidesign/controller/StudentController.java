package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.pojo.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/{id}")
    public Student findStudentById(@PathVariable Integer id){
        return studentService.findStudentById(id);
    }

    @PostMapping
    public void saveStudent(@RequestBody Student student){
        studentService.saveStudent(student);
    }

    @GetMapping
    public List<Student> findStudentList(@RequestParam(required = false)Gender gender){
        return studentService.findStudentsByGender(gender);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Integer id){
        studentService.deleteStudentById(id);
    }

    @PatchMapping()
    public void updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
    }
}
