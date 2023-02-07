package com.hypeboy.HoTalking.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ExceptionCode {

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 유저를 찾지 못함"),
    USER_EXISTS(HttpStatus.BAD_REQUEST, "이미 존재하는 유저"),
    INVALID_PERMISSION(HttpStatus.BAD_REQUEST, "유효하지 않은 권한"),

    PASSWORD_NOT_MATCH(HttpStatus.BAD_REQUEST, "비밀번호가 일치하지 않음"),
    SAME_PASSWORD(HttpStatus.BAD_REQUEST, ""),

    EXPIRED_TOKEN(HttpStatus.UNAUTHORIZED, "만료된 토큰"),
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "유효하지 않은 토큰"),

    ENCRYPT(HttpStatus.INTERNAL_SERVER_ERROR, "암호화 오류");

    private final HttpStatus status;
    private final String msg;

}