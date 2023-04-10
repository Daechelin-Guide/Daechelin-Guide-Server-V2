package com.v2.daechelinguide.global.exception;

import com.v2.daechelinguide.global.response.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Response> customHandler(CustomException e) {
        return new ResponseEntity<>(
                new Response(e.getStatus(), e.getMessage()),
                    e.getStatus()
                );

    }
}
