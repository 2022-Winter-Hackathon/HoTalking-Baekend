package com.hypeboy.HoTalking.domain.member.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    JUNIOR("ROLE_JUNIOR", "후배"),
    SENIOR("ROLE_SENIOR", "선배"),
    TEACHER("ROLE_TEACHER", "" +
            "선생님"),
    ADMIN("ROLE_ADMIN", "학교짱");

    private final String key;

    private final String content;

}