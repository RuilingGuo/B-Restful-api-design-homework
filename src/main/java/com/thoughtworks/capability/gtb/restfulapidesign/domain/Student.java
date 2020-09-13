package com.thoughtworks.capability.gtb.restfulapidesign.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thoughtworks.capability.gtb.restfulapidesign.pojo.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {

    private Integer id;
    private String name;
    private Gender gender;
    private String note;
}
