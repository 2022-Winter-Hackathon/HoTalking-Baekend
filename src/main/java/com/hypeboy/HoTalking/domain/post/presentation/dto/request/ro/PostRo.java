package com.hypeboy.HoTalking.domain.post.presentation.dto.request.ro;

import com.hypeboy.HoTalking.domain.comment.presentation.dto.request.ro.CommentRo;
import com.hypeboy.HoTalking.domain.member.domain.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class PostRo {

    private String title;

    private String content;

    private String author;

    private Role role;

    private  List<CommentRo> comments;

}
