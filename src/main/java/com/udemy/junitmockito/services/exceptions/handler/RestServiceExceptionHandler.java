package com.udemy.junitmockito.services.exceptions.handler;

import com.udemy.junitmockito.config.JsonExceptionConfig;
import com.udemy.junitmockito.services.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestServiceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<JsonExceptionConfig> objectNotFoundException(ObjectNotFoundException exception,
                                                                       HttpServletRequest path){
        JsonExceptionConfig exceptionConfig = new JsonExceptionConfig(
                LocalDateTime.now(),
                path.getRequestURI(),
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionConfig);
    }
}
