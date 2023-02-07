package com.hypeboy.HoTalking.domain.post.entity.dto.request.ro;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@AllArgsConstructor
public class PostRo {

    private String title;

    private String author;

    private String content;

    private List<MultipartFile> file;


}
