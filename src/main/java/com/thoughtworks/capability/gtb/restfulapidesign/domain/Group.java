package com.thoughtworks.capability.gtb.restfulapidesign.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Group {
    private Integer id;
    private String name;
    private String note;

    List<Student> studentList;

    public Group(Integer id, Integer groupIndex) {
        this.id = id;
        this.name ="Group "+groupIndex;
        this.studentList = new ArrayList<>();
    }

    public void addStudent(Student student){
        this.studentList.add(student);
    }
}
