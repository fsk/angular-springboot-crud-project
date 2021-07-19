package com.vektorel.fullbackendproject.exceptions.employee_exceptions;

import com.vektorel.fullbackendproject.exceptions.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class Employee_Exceptions extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmployeeAlreadyExistException.class)
    public ResponseEntity<Object> handleEmployeeAlreadyExists(EmployeeAlreadyExistException exception, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse();
        response.setExceptionMessage("Email Already Exists.!!");
        response.setExceptionDateTime(LocalDateTime.now());
        ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.BAD_GATEWAY);
        return entity;
    }


    @ExceptionHandler(EmployeeInvalidEmailException.class)
    public ResponseEntity<Object> handleEmployeeInvalidEmail(EmployeeInvalidEmailException exception, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse();
        response.setExceptionMessage("Invalid EMail.!!");
        response.setExceptionDateTime(LocalDateTime.now());
        ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        return entity;
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Object> handleEmployeeNotFoundException(EmployeeNotFoundException exception, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse();
        response.setExceptionMessage("Employee Not Found");
        response.setExceptionDateTime(LocalDateTime.now());
        ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        return entity;
    }
}
