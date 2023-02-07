package com.hypeboy.HoTalking.global.error.exception.token;

import com.hypeboy.HoTalking.global.error.CustomException;
import com.hypeboy.HoTalking.global.error.ExceptionCode;

public class ExpiredTokenException extends CustomException {

    public static final CustomException EXCEPTION = new ExpiredTokenException();

    public ExpiredTokenException() {
        super(ExceptionCode.EXPIRED_TOKEN);
    }

}
