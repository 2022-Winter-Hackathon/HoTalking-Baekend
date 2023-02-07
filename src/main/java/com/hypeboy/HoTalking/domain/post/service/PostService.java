package com.hypeboy.HoTalking.domain.post.service;

import com.hypeboy.HoTalking.domain.image.Image;
import com.hypeboy.HoTalking.domain.image.ImageService;
import com.hypeboy.HoTalking.domain.member.domain.entity.Member;
import com.hypeboy.HoTalking.domain.member.domain.repository.MemberRepository;
import com.hypeboy.HoTalking.domain.post.Repository.PostRepository;
import com.hypeboy.HoTalking.domain.post.entity.Post;
import com.hypeboy.HoTalking.domain.post.entity.dto.request.CreatePostRequest;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@AllArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;
    private final ImageService imageService;

    @Transactional
    public ResponseEntity<?> createPost(CreatePostRequest request,
                                        final Member member) throws Exception {
        final Post post = postRepository.save(Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build());
        final List<MultipartFile> files = request.getFiles();

        if (files != null && !files.isEmpty()) {
            imageService.addImage(Image.builder().build(), files, post);
        }

        final Post savedPost = postRepository.save(post);

        member.addPost(savedPost);
        memberRepository.save(member);
        return ResponseEntity.ok().build();
    }


    public ResponseEntity<?> deletePost(Long id) {
        postRepository.deleteById(id);
        return ResponseEntity.ok("삭제 되었습니다");
    }
}
