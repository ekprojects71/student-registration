package com.student.registration.studentregistration.Exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAllExceptions(Exception e, WebRequest request) {

        String message = e.getLocalizedMessage() == null ? ( e.toString() ) : ( e.getLocalizedMessage() );

        return  new ResponseEntity<>( message, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR );
    }
}
