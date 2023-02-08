package com.hypeboy.HoTalking.domain.post.presentation;

import com.hypeboy.HoTalking.domain.member.domain.entity.Member;
import com.hypeboy.HoTalking.domain.post.presentation.dto.request.ro.PostListRo;
import com.hypeboy.HoTalking.domain.post.presentation.dto.request.ro.PostRo;
import com.hypeboy.HoTalking.domain.post.service.PostService;
import com.hypeboy.HoTalking.domain.post.presentation.dto.request.CreatePostRequest;
import com.hypeboy.HoTalking.global.annotation.AuthToken;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequestMapping("/api/post")
@RestController
@AllArgsConstructor
public class PostController {

    private static final Logger log = LoggerFactory.getLogger(PostController.class);

    private final PostService postService;

    @AuthToken
    @PostMapping("/create")
    public ResponseEntity<?> createPost(@RequestParam(required = false) List<MultipartFile> files,
            @RequestParam String title, @RequestParam String content,
            @RequestAttribute Member member) throws Exception {
        log.info("{}", files);
        return postService.createPost(new CreatePostRequest(title, content, files), member);
    }
    @ApiOperation(value = "이미지 받아오오는 컨트롤러 return byte[]")
    @GetMapping(value = "/images/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImage(@PathVariable long id) throws IOException {
        return postService.getImage(id);
    }

    @AuthToken
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePost(@RequestAttribute Member member,
                                        @PathVariable("id") Long id) {
        return postService.deletePost(id, member);
    }

    @GetMapping("/list")
    public List<PostListRo> findAll() {
        return postService.findAll();
    }

    @GetMapping("/{id}")
    private PostRo getPostById(@PathVariable("id") Long id) {
        log.info(String.valueOf(id));
        return postService.getPostById(id);
    }
}
