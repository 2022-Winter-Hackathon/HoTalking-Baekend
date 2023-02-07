package com.hypeboy.HoTalking.domain.member.domain.entity;

import com.hypeboy.HoTalking.domain.comment.domain.entity.Comment;
import com.hypeboy.HoTalking.domain.member.domain.enums.Role;
import com.hypeboy.HoTalking.domain.post.entity.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String m_id;

    private int grade;

    private int room;

    private int number;

    private String name;

    private String profileImage;

    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "author")
    private List<Post> postList;

    @OneToMany(mappedBy = "author")
    private List<Comment> commentList;

    @Builder
    public Member(String m_id, int grade, int number, String name, String profileImage, String email, Role role, int room, List<Post> postList, List<Comment> commentList) {
        this.m_id = m_id;
        this.grade = grade;
        this.number = number;
        this.room = room;
        this.name = name;
        this.profileImage = profileImage;
        this.email = email;
        this.role = role;
        this.postList = postList;
        this.commentList = commentList;
    }

}