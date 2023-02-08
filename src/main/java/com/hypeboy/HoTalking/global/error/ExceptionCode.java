package com.hypeboy.HoTalking.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ExceptionCode {

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 유저를 찾지 못함"),
    COMMENT_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 댓글을 찾지 못함"),

    INVALID_PERMISSION(HttpStatus.BAD_REQUEST, "유효하지 않은 권한"),
    PASSWORD_NOT_MATCH(HttpStatus.BAD_REQUEST, "비밀번호가 일치하지 않음"),
    MEMBER_EXIST(HttpStatus.BAD_REQUEST, "이미 멤버가 존재함"),
    MEMBER_NOT_MATCH(HttpStatus.BAD_REQUEST, "멤버가 일치하지 않음"),
    TAMPERED_CODE(HttpStatus.BAD_REQUEST, "변조된 코드"),

    INTERNAL_SERVER(HttpStatus.INTERNAL_SERVER_ERROR, "서버 통신 중 오류"),

    NO_TOKEN(HttpStatus.UNAUTHORIZED, "토큰이 없음"),
    EXPIRED_TOKEN(HttpStatus.UNAUTHORIZED, "만료된 토큰"),
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "유효하지 않은 토큰");


    private final HttpStatus status;
    private final String msg;

}