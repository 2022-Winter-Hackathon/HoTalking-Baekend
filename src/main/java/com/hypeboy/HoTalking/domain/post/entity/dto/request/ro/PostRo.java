package com.hypeboy.HoTalking.domain.post.entity.dto.request.ro;

import com.hypeboy.HoTalking.domain.comment.domain.entity.Comment;
import com.hypeboy.HoTalking.domain.comment.presentation.dto.request.ro.CommentRo;
import com.hypeboy.HoTalking.domain.member.domain.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

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
