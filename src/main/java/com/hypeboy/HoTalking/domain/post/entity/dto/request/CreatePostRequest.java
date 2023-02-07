package com.hypeboy.HoTalking.domain.post.entity.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Getter
public class CreatePostRequest {

    @NotBlank
    private String token;

    @NotBlank(message = "제목이 필요합니다")
    private String title;

    @NotBlank(message = "내용이 필요합니다")
    private String content;

    private MultipartFile file;
}
