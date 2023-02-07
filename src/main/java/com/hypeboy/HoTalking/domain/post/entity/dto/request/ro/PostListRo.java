package com.hypeboy.HoTalking.domain.post.entity.dto.request.ro;

import com.hypeboy.HoTalking.domain.post.entity.Post;
import lombok.Getter;

@Getter
public class PostListRo {
    private Long id;
    private String title;

    public PostListRo(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
    }
}
