package com.hypeboy.HoTalking.domain.post.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@AllArgsConstructor
@Getter
public class CreatePostRequest {

    private String title;

    private String content;

    private List<MultipartFile> files;
}