package com.hypeboy.HoTalking.domain.comment.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor @NoArgsConstructor
public class CreateCommentRequest {

    @NotBlank
    private String token;

    @NotBlank
    private Long post_id;

    @NotBlank
    private String content;

}