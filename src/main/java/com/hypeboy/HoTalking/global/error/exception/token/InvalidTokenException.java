package com.hypeboy.HoTalking.global.error.exception.token;

import com.hypeboy.HoTalking.global.error.CustomException;
import com.hypeboy.HoTalking.global.error.ExceptionCode;

public class InvalidTokenException extends CustomException {

    private static final CustomException EXCEPTION = new InvalidTokenException();

    public InvalidTokenException() {
        super(ExceptionCode.INVALID_TOKEN);
    }

}