package com.hypeboy.HoTalking.global.error.exception;

import com.hypeboy.HoTalking.global.error.CustomException;
import com.hypeboy.HoTalking.global.error.ExceptionCode;

public class NoTokenException extends CustomException {

    public static final CustomException EXCEPTION = new NoTokenException();

    public NoTokenException() {
        super(ExceptionCode.NO_TOKEN);
    }

}