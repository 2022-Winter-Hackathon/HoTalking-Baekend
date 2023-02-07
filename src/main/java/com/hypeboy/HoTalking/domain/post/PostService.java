package com.hypeboy.HoTalking.domain.post;

import com.hypeboy.HoTalking.domain.file.File;
import com.hypeboy.HoTalking.domain.file.FileService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PostService {

    private final FileService fileService;

    private final PostRepository postRepository;

    public ResponseEntity<?> createPost(CreatePostRequest request) throws Exception {

        Post post = Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build();

        post.setFile(fileService.registerFile(request.getFile()));

        postRepository.save(post);

        return ResponseEntity.ok("저장 되었습니다");
    }
}
