package com.hypeboy.HoTalking.domain.member.domain.entity;

import com.hypeboy.HoTalking.domain.member.domain.enums.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    /*
    @OneToMany(mappedBy = "writer")
    private List<Object> myPost = new ArrayList<>();
    */
    @Builder
    public Member(String m_id, int grade, int number, String name, String profileImage, String email, Role role, int room) {
        this.m_id = m_id;
        this.grade = grade;
        this.number = number;
        this.room = room;
        this.name = name;
        this.profileImage = profileImage;
        this.email = email;
        this.role = role;
    }

}