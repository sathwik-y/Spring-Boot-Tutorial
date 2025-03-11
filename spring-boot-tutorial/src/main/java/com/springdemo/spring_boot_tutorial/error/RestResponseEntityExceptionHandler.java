package com.springdemo.spring_boot_tutorial.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.springdemo.spring_boot_tutorial.entities.ErrorMessage;

import io.micrometer.core.ipc.http.HttpSender;



@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler{

    @ExceptionHandler(NameNotFoundException.class)
    public ResponseEntity<ErrorMessage> nameNotFoundException(NameNotFoundException ex) {
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND,ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorMessage> departmentNotFouException(DepartmentNotFoundException ex) {
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND,ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
}
    