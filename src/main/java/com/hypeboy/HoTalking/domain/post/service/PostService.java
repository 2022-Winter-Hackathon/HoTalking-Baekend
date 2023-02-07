package com.hypeboy.HoTalking.domain.post.service;

import com.hypeboy.HoTalking.domain.image.Image;
import com.hypeboy.HoTalking.domain.image.ImageHandler;
import com.hypeboy.HoTalking.domain.image.ImageRepository;
import com.hypeboy.HoTalking.domain.image.ImageService;
import com.hypeboy.HoTalking.domain.post.Repository.PostRepository;
import com.hypeboy.HoTalking.domain.post.entity.Post;
import com.hypeboy.HoTalking.domain.post.entity.dto.request.CreatePostRequest;
import com.hypeboy.HoTalking.domain.post.entity.dto.request.ro.PostRo;
import com.hypeboy.HoTalking.global.error.exception.PostNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PostService {

    private final PostRepository postRepository;


    private final ImageService imageService;



    @Transactional
    public ResponseEntity<?> createPost(CreatePostRequest request) throws Exception {
        final Post post = postRepository.save(Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build());
        System.out.println(post.getId());
        imageService.addImage(Image.builder().build(), request.getFiles(), post);

        return ResponseEntity.ok().build();
    }


    public ResponseEntity<?> deletePost(Long id) {
        postRepository.deleteById(id);
        return ResponseEntity.ok("삭제 되었습니다");
    }

/*    public PostRo getPostById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION
                );


        return new PostRo(post.getTitle(), post.getAuthor(),post.getContent(), post.getFile());
    }*/
}
