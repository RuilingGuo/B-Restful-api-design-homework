package com.thoughtworks.capability.gtb.restfulapidesign.exception.handler;

import com.thoughtworks.capability.gtb.restfulapidesign.exception.GroupNotFoundException;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.StudentNotFoundException;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.error.ErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler({GroupNotFoundException.class, StudentNotFoundException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleNotFoundBadRequest(RuntimeException ex) {
        log.warn("invalid request", ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value())
                .body(new ErrorMessage(ex.getMessage(), HttpStatus.BAD_REQUEST.value()));
    }


}