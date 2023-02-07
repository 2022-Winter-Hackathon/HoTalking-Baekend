package com.hypeboy.HoTalking.domain.auth.presentation.dto.api;

import com.hypeboy.HoTalking.domain.comment.domain.entity.Comment;
import com.hypeboy.HoTalking.domain.member.domain.entity.Member;
import com.hypeboy.HoTalking.domain.member.domain.enums.Role;
import com.hypeboy.HoTalking.domain.post.entity.Post;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    private List<Post> postList;

    private List<Comment> commentList;

    public DodamInfoDto(DodamInfoDto data) {
        this.m_id = data.getM_id();
        this.grade = data.getGrade();
        this.room = data.getRoom();
        this.number = data.getNumber();
        this.name = data.getName();
        this.email = data.getEmail();
        this.profileImage = data.getProfileImage();
        this.accessLevel = data.getAccessLevel();
        this.postList = new ArrayList<>();
        this.commentList = new ArrayList<>();
    }

    public static Member toEntity(DodamInfoDto data) {
        Role role = data.accessLevel==2?Role.TEACHER:data.grade>1?Role.SENIOR:Role.JUNIOR;
        return Member.builder()
                .m_id(data.getM_id())
                .name(data.getName())
                .grade(data.getGrade())
                .number(data.getNumber())
                .room(data.getRoom())
                .profileImage(data.getProfileImage())
                .role(role)
                .postList(data.postList)
                .commentList(data.commentList)
                .build();
    }

}