package org.example.springboot.controller;

import org.example.springboot.Dtos.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiResponse>  handleHttpMessageNotReadable(HttpMessageNotReadableException e){

        return ResponseEntity.badRequest()
                .body(new ApiResponse("Invalid Input for Level field" , null) );

    }

}
