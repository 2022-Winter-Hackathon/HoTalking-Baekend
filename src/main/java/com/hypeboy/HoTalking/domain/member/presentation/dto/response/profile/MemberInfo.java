package com.hypeboy.HoTalking.domain.member.presentation.dto.response.profile;

import com.hypeboy.HoTalking.domain.member.domain.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor @NoArgsConstructor
public class MemberInfo {

    private long id;

    private String uniqueId;

    private int grade;

    private int room;

    private int number;

    private String name;

    private String profileImage;

    private String email;

    private Role role;

}