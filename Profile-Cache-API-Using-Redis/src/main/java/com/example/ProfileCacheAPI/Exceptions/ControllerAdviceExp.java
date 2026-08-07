package com.example.ProfileCacheAPI.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceExp {


    @ExceptionHandler(ProfileNotFoundException.class)
    public ResponseEntity<String> send(){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Profile Not Found: FUUUCKKK OFFFF");
    }
}
