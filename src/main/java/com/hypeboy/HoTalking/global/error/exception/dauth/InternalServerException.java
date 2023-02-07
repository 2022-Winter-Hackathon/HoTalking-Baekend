package com.hypeboy.HoTalking.global.error.exception.dauth;

import com.hypeboy.HoTalking.global.error.CustomException;
import com.hypeboy.HoTalking.global.error.ExceptionCode;

public class InternalServerException extends CustomException {

    public static final CustomException EXCEPTION = new InternalServerException();

    public InternalServerException() {
        super(ExceptionCode.INTERNAL_SERVER);
    }

}