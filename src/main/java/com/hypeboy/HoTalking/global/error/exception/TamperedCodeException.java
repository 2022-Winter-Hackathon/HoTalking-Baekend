package com.hypeboy.HoTalking.global.error.exception;

import com.hypeboy.HoTalking.global.error.CustomException;
import com.hypeboy.HoTalking.global.error.ExceptionCode;

public class TamperedCodeException extends CustomException {

    public static final CustomException EXCEPTION = new TamperedCodeException();

    public TamperedCodeException() {
        super(ExceptionCode.TAMPERED_CODE);
    }

}