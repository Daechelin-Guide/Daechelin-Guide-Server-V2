package com.v2.daechelinguide.global.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class Response {
    private int status;
    private String message;

    public Response(HttpStatus status, String message) {
        this.status = status.value();
        this.message = message;
    }
}
