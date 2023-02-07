package com.hypeboy.HoTalking.domain.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@Getter
public class CreatePostRequest {

    private String title;

    private String author;

    private String content;

    private MultipartFile file;
}
