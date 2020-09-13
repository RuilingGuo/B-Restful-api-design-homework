package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static javax.swing.UIManager.get;

@Service
public class StudentService {

    private final Map<Integer,Student> studentList;
    private static Integer STUDENT_INC_ID = 0;

    public StudentService() {
        this.studentList = new HashMap<>();
    }

    public Student findStudentById(Integer id) {
        Optional<Student> studentOptional = Optional.ofNullable(studentList.get(id));
        if(!studentOptional.isPresent()){
            throw new UserNotFoundException("此用户不存在");
        }
        return studentOptional.get();
    }

    public void saveStudent(Student student){
        studentList.put(STUDENT_INC_ID,student);
        STUDENT_INC_ID++;
    }

}
