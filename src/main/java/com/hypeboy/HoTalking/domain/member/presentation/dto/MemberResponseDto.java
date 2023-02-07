package com.hypeboy.HoTalking.domain.member.presentation.dto;

import com.hypeboy.HoTalking.domain.member.domain.entity.Member;
import com.hypeboy.HoTalking.domain.member.domain.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponseDto {

    private long userId;

    private String m_id;

    private int grade;

    private int room;

    private int number;

    private String name;

    private String profileImage;

    private String email;

    private Role role;

    public MemberResponseDto(Member member) {
        this.userId = member.getId();
        this.m_id = member.getM_id();
        this.grade = member.getGrade();
        this.room = member.getRoom();
        this.number = member.getNumber();
        this.name = member.getName();
        this.profileImage = member.getProfileImage();
        this.email = member.getEmail();
        this.role = member.getRole();
    }

}