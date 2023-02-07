package com.hypeboy.HoTalking.domain.post.service;

import com.hypeboy.HoTalking.domain.file.FileService;
import com.hypeboy.HoTalking.domain.post.Repository.PostRepository;
import com.hypeboy.HoTalking.domain.post.entity.Post;
import com.hypeboy.HoTalking.domain.post.entity.dto.request.CreatePostRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostService {
    /**
     QWERTYqwertyQWERTY
     */

    private final FileService fileService;

    private final PostRepository postRepository;
    public ResponseEntity<?> createPost(CreatePostRequest request) throws Exception {

        Post post = Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build();

        if(request.getFile() != null) {
            post.setFile(fileService.registerFile(request.getFile()));
        }

        postRepository.save(post);

        return ResponseEntity.ok("저장 되었습니다");
    }

    public ResponseEntity<?> deletePost(Long id) {
        postRepository.deleteById(id);
        return ResponseEntity.ok("삭제 되었습니다");
    }
}
