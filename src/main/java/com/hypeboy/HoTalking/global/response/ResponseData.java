package com.hypeboy.HoTalking.global.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ResponseData<T> extends Response {

    private final T data;

    public ResponseData(HttpStatus status, String msg, T data) {
        super(status, msg);
        this.data = data;
    }


}