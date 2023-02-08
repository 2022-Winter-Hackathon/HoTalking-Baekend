package com.hypeboy.HoTalking.domain.member.presentation;

import com.hypeboy.HoTalking.domain.member.domain.entity.Member;
import com.hypeboy.HoTalking.domain.member.presentation.dto.response.MemberProfileResponseDto;
import com.hypeboy.HoTalking.domain.member.presentation.dto.response.MemberResponseDto;
import com.hypeboy.HoTalking.domain.member.service.MemberService;
import com.hypeboy.HoTalking.global.annotation.AuthToken;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @AuthToken
    @GetMapping
    public MemberResponseDto findMember(@RequestAttribute Member member) {
        return new MemberResponseDto(member);
    }

    @AuthToken
    @PostMapping(value = "/profile")
    public MemberProfileResponseDto getMyProfile(@RequestAttribute Member member) {
        return memberService.getMyInfo(member);
    }

}