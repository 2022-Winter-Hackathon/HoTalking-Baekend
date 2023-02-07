package com.hypeboy.HoTalking.global.error;

import com.hypeboy.HoTalking.global.response.ResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    protected ResponseEntity<ResponseError> handleCustomException(CustomException e){
        final ResponseError responseError = ResponseError.builder()
                .status(e.getExceptionCode().getStatus())
                .msg(e.getExceptionCode().getMsg())
                .build();
        return ResponseEntity.status(e.getExceptionCode().getStatus()).body(responseError);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ResponseError> handleException(Exception e){
        ResponseError responseError = ResponseError.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .msg(e.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseError);
    }

}