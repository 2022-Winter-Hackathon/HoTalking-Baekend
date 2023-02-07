package com.hypeboy.HoTalking.domain.member.exception;

import com.hypeboy.HoTalking.global.error.CustomException;
import com.hypeboy.HoTalking.global.error.ExceptionCode;

public class MemberNotFoundException extends CustomException {

    public static final CustomException EXCEPTION = new MemberNotFoundException();

    public MemberNotFoundException() {
        super(ExceptionCode.USER_NOT_FOUND);
    }
}