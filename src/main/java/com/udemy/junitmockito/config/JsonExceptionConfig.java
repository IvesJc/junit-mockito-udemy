package com.udemy.junitmockito.config;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JsonExceptionConfig {

    private LocalDateTime timestamp;
    private String  path;
    private Integer httpStattusCode;
    private String message;
}
