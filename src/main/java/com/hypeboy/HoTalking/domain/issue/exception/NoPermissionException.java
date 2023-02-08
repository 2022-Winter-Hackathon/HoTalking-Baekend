package com.hypeboy.HoTalking.domain.issue.exception;

import com.hypeboy.HoTalking.global.error.CustomException;
import com.hypeboy.HoTalking.global.error.ExceptionCode;

public class NoPermissionException extends CustomException {

    public static final CustomException EXCEPTION = new NoPermissionException();

    public NoPermissionException() {
        super(ExceptionCode.NO_PERMISSION);
    }

}