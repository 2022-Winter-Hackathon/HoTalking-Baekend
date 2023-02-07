package com.hypeboy.HoTalking.domain.member.exception;

import com.hypeboy.HoTalking.global.error.CustomException;
import com.hypeboy.HoTalking.global.error.ExceptionCode;

public class MemberExistException extends CustomException {

    public static final CustomException EXCEPTION = new MemberExistException();

    public MemberExistException() {
        super(ExceptionCode.USER_NOT_FOUND);
    }

}