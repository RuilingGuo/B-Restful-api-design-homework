package com.thoughtworks.capability.gtb.restfulapidesign.exception.error;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessage {
    private String message;
    private int code;
}
