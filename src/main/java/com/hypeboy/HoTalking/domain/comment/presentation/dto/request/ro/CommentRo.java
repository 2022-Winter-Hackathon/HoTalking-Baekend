package com.hypeboy.HoTalking.domain.comment.presentation.dto.request.ro;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor @NoArgsConstructor
public class CommentRo {
    private Long id;
    private String comment;
}
