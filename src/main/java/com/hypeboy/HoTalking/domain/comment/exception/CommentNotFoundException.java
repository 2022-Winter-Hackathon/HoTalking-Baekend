package com.hypeboy.HoTalking.domain.comment.exception;

import com.hypeboy.HoTalking.global.error.CustomException;
import com.hypeboy.HoTalking.global.error.ExceptionCode;

public class CommentNotFoundException extends CustomException {

    public static final CustomException EXCEPTION = new CommentNotFoundException();

    public CommentNotFoundException() {
        super(ExceptionCode.COMMENT_NOT_FOUND);
    }

}