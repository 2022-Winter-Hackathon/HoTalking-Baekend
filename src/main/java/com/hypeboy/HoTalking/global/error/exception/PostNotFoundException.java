package com.hypeboy.HoTalking.global.error.exception;

import com.hypeboy.HoTalking.global.error.CustomException;
import com.hypeboy.HoTalking.global.error.ExceptionCode;

public class PostNotFoundException extends CustomException {

    public static final CustomException EXCEPTION = new PostNotFoundException();

    public PostNotFoundException() {
        super(ExceptionCode.INTERNAL_SERVER);
    }

}