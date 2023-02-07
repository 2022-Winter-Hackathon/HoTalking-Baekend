package com.hypeboy.HoTalking.domain.comment.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class CreateCommentRequest {

    @NotBlank
    private String token;

    @NotBlank
    private Long post_id;

    @NotBlank
    private String content;

}