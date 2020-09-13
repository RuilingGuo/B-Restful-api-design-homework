package com.thoughtworks.capability.gtb.restfulapidesign.pojo;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Gender {
    MALE("男"), FEMALE("女");

    private String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    @JsonValue
    public String getGender() {
        return this.gender;
    }

}
