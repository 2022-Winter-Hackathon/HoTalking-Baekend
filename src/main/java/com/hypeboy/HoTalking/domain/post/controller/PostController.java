package com.hypeboy.HoTalking.domain.post.controller;

import com.hypeboy.HoTalking.domain.image.Image;
import com.hypeboy.HoTalking.domain.image.ImageService;
import com.hypeboy.HoTalking.domain.post.entity.dto.request.ro.PostRo;
import com.hypeboy.HoTalking.domain.post.service.PostService;
import com.hypeboy.HoTalking.domain.post.entity.dto.request.CreatePostRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/post")
@RestController
@AllArgsConstructor
public class PostController {

    private final PostService postService;
    private final ImageService imageService;

    @PostMapping("/create")
    public ResponseEntity<?> createPost(@ModelAttribute CreatePostRequest request) throws Exception {
        return postService.createPost(request);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePost(@PathVariable("id") Long id) {
        return postService.deletePost(id);
    }
}
