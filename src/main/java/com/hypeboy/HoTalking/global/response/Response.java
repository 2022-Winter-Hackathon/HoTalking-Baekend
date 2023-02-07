package com.hypeboy.HoTalking.global.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class Response {

    private int status;
    private String msg;

    public Response(HttpStatus status, String msg) {
        this.status = status.value();
        this.msg = msg;
    }

}