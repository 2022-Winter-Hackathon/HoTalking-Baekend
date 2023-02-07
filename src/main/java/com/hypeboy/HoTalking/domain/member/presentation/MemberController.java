package com.hypeboy.HoTalking.domain.member.presentation;

import com.hypeboy.HoTalking.domain.member.domain.entity.Member;
import com.hypeboy.HoTalking.domain.member.presentation.dto.MemberResponseDto;
import com.hypeboy.HoTalking.global.annotation.AuthToken;
import com.hypeboy.HoTalking.global.lib.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/member")
@RequiredArgsConstructor
public class MemberController {

    private final JwtUtil jwtUtil;

    @AuthToken
    @GetMapping
    public MemberResponseDto findMember(@RequestAttribute Member member) {
        return new MemberResponseDto(member);
    }

}