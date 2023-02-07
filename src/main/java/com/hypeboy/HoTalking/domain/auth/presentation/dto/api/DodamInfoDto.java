package com.hypeboy.HoTalking.domain.auth.presentation.dto.api;

import com.hypeboy.HoTalking.domain.member.domain.entity.Member;
import com.hypeboy.HoTalking.domain.member.domain.enums.Role;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DodamInfoDto implements Serializable {

    private String m_id;
    private int grade;
    private int room;
    private int number;
    private String name;
    private String email;
    private String profileImage;
    private int accessLevel;

    public DodamInfoDto(DodamInfoDto data) {
        this.m_id = data.getM_id();
        this.grade = data.getGrade();
        this.room = data.getRoom();
        this.number = data.getNumber();
        this.name = data.getName();
        this.email = data.getEmail();
        this.profileImage = data.getProfileImage();
        this.accessLevel = data.getAccessLevel();
    }

    public static Member toEntity(DodamInfoDto data) {
        Role role = Role.JUNIOR;
        return Member.builder()
                .m_id(data.getM_id())
                .name(data.getName())
                .grade(data.getGrade())
                .number(data.getNumber())
                .room(data.getRoom())
                .profileImage(data.getProfileImage())
                .role(role)
                .build();
    }

}