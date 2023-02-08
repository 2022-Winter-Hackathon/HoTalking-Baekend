package com.hypeboy.HoTalking.domain.post.presentation.dto.request.ro;

import com.hypeboy.HoTalking.domain.post.domain.entity.Post;
import lombok.Getter;

@Getter
public class PostListRo {
    private final Long id;
    private final String title;

    private final String author;

    private final String role;

    public PostListRo(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.author = post.getAuthor().getName();
        this.role = post.getAuthor().getRole().getContent();
    }
}
