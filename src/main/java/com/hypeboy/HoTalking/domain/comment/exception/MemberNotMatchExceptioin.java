package com.hypeboy.HoTalking.domain.comment.exception;

import com.hypeboy.HoTalking.global.error.CustomException;
import com.hypeboy.HoTalking.global.error.ExceptionCode;

public class MemberNotMatchExceptioin extends CustomException {

    public static final CustomException EXCEPTION = new MemberNotMatchExceptioin();

    public MemberNotMatchExceptioin() {
        super(ExceptionCode.MEMBER_NOT_MATCH);
    }

}