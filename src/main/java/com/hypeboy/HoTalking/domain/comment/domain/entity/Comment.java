package com.hypeboy.HoTalking.domain.comment.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hypeboy.HoTalking.domain.member.domain.entity.Member;
import com.hypeboy.HoTalking.domain.post.domain.entity.Post;
import com.hypeboy.HoTalking.global.jpa.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member author;

    @NotBlank
    private String content;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

}