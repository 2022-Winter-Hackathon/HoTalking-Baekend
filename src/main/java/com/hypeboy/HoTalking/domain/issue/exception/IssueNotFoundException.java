package com.hypeboy.HoTalking.domain.issue.exception;

import com.hypeboy.HoTalking.global.error.CustomException;
import com.hypeboy.HoTalking.global.error.ExceptionCode;

public class IssueNotFoundException extends CustomException {

    public static final CustomException EXCEPTION = new IssueNotFoundException();

    public IssueNotFoundException() {
        super(ExceptionCode.EXPIRED_TOKEN);
    }

}
