package com.hypeboy.HoTalking.domain.post.service;

import com.hypeboy.HoTalking.domain.file.FileService;
import com.hypeboy.HoTalking.domain.member.domain.entity.Member;
import com.hypeboy.HoTalking.domain.member.domain.repository.MemberRepository;
import com.hypeboy.HoTalking.domain.post.Repository.PostRepository;
import com.hypeboy.HoTalking.domain.post.entity.Post;
import com.hypeboy.HoTalking.domain.post.entity.dto.request.CreatePostRequest;
import com.hypeboy.HoTalking.domain.post.exception.PostNotFoundException;
import com.hypeboy.HoTalking.global.lib.jwt.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostService {
    /**
     QWERTYqwertyQWERTY
     */

    private final JwtUtil jwtUtil;

    private final FileService fileService;

    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    public ResponseEntity<?> createPost(CreatePostRequest request) throws Exception {

        Post post = Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build();
        if(request.getFile() != null) {
            post.setFile(fileService.registerFile(request.getFile()));
        }
        final Post savedPost = postRepository.save(post);

        Member member = jwtUtil.getMemberByToken(request.getToken());

        member.addPost(savedPost);
        memberRepository.save(member);

        return ResponseEntity.ok("게시글 저장 되었습니다");
    }

    public ResponseEntity<?> deletePost(Long id) {

        Post post = postRepository.findById(id)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);

        Member member = post.getAuthor();

        member.removePost(post);
        memberRepository.save(member);

        postRepository.deleteById(id);

        return ResponseEntity.ok("게시글 삭제 되었습니다");
    }
}
