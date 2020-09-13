package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.UserNotFoundException;
import com.thoughtworks.capability.gtb.restfulapidesign.pojo.Gender;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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
        student.setId(STUDENT_INC_ID);
        studentList.put(STUDENT_INC_ID,student);
        STUDENT_INC_ID++;
    }

    public List<Student> findStudentsByGender(Gender gender) {
        List<Student> students = new ArrayList<Student>(studentList.values());
        if(gender==null){
            return students;
        }
        return students.stream().filter(student -> student.getGender()==gender).collect(Collectors.toList());
    }

    public void deleteStudentById(Integer id) {
        studentList.remove(id);
    }
}
