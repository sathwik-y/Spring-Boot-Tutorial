package com.springdemo.spring_boot_tutorial.entities;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
    public HttpStatus status;
    public String message;
}
