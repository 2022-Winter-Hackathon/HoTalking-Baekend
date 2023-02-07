package com.hypeboy.HoTalking.domain.member.service;

import com.hypeboy.HoTalking.domain.auth.presentation.dto.api.DOpenApiDto;
import com.hypeboy.HoTalking.domain.auth.presentation.dto.api.DodamInfoDto;
import com.hypeboy.HoTalking.domain.member.domain.entity.Member;
import com.hypeboy.HoTalking.domain.member.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Member save(DOpenApiDto dOpenApiDto) {
        DodamInfoDto data = dOpenApiDto.getDodamInfoData();
        Member member = DodamInfoDto.toEntity(data);
        if(isExisted(member)) {
            return member;
        }

        return memberRepository.save(member);
    }

    @Transactional
    protected boolean isExisted(Member member) {
        return memberRepository.existsByGradeAndNumberAndRoom(member.getGrade(), member.getNumber(), member.getRoom());
    }
}