package com.hypeboy.HoTalking.domain.post.entity.dto.request.ro;

import com.hypeboy.HoTalking.domain.post.entity.Post;
import lombok.Getter;

@Getter
public class PostListRo {
    private Long id;
    private String title;

    private String author;

    private String role;

    public PostListRo(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.author = post.getAuthor().getName();
        this.role = post.getAuthor().getRole().getContent();
    }
}
