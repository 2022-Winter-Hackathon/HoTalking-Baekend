package com.hypeboy.HoTalking.domain.post.service;

import com.hypeboy.HoTalking.domain.image.ImageService;
import com.hypeboy.HoTalking.domain.member.domain.entity.Member;
import com.hypeboy.HoTalking.domain.member.domain.repository.MemberRepository;
import com.hypeboy.HoTalking.domain.post.Repository.PostRepository;
import com.hypeboy.HoTalking.domain.post.entity.Post;
import com.hypeboy.HoTalking.domain.post.entity.dto.request.CreatePostRequest;

import lombok.AllArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
        System.out.println(files);

        if (files != null && !files.isEmpty()) {
            imageService.addImage(files, post);
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

    public ResponseEntity<?> findAllImages(final long id) {
        return ResponseEntity.ok(postRepository.findById(id)
                .orElseThrow()
                .getImages());
    }

    public byte[] getImage(final long id) throws IOException {
        try (final InputStream stream = new FileInputStream(imageService.getImage(id))) {
            return IOUtils.toByteArray(stream);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

}
