package com.hypeboy.HoTalking.domain.post.service;

import com.hypeboy.HoTalking.domain.comment.domain.repository.CommentRepository;
import com.hypeboy.HoTalking.domain.comment.presentation.dto.request.ro.CommentRo;
import com.hypeboy.HoTalking.domain.image.ImageService;
import com.hypeboy.HoTalking.domain.issue.entity.Issue;
import com.hypeboy.HoTalking.domain.issue.service.IssueService;
import com.hypeboy.HoTalking.domain.member.domain.entity.Member;
import com.hypeboy.HoTalking.domain.member.domain.repository.MemberRepository;
import com.hypeboy.HoTalking.domain.post.Repository.PostRepository;
import com.hypeboy.HoTalking.domain.post.entity.Post;
import com.hypeboy.HoTalking.domain.post.entity.dto.request.CreatePostRequest;

import com.hypeboy.HoTalking.domain.post.entity.dto.request.ro.PostListRo;
import com.hypeboy.HoTalking.domain.post.entity.dto.request.ro.PostRo;
import com.hypeboy.HoTalking.domain.post.exception.PostNotFoundException;
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
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    private final MemberRepository memberRepository;

    private final CommentRepository commentRepository;

    private final ImageService imageService;

    private final IssueService issueService;

    @Transactional
    public ResponseEntity<?> createPost(CreatePostRequest request,
                                        final Member member) throws Exception {
        Issue issue = issueService.getIssue();

        final Post post = postRepository.save(Post
                .builder()
                .title(request.getTitle())
                .content(request.getContent())
                .author(member)
                .issue(issue)
                .role(member.getRole().getKey())
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
        Post post = postRepository.findById(id)
                        .orElseThrow(() -> PostNotFoundException.EXCEPTION);

        Issue issue = post.getIssue();
        issue.removePost(post);
        issueService.save(issue);

        postRepository.deleteById(id);

        return ResponseEntity.ok("삭제 되었습니다");
    }

    public List<PostListRo> findAll() {
        return postRepository.findAll()
                .stream()
                .map(PostListRo::new)
                .collect(Collectors.toList());
    }

    public PostRo getPostById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);

        List<CommentRo> comments = commentRepository.findByPost_Id(id)
                .stream().map(it -> new CommentRo(it.getId(), it.getContent()))
                .toList();

        return PostRo.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .author(post.getAuthor().getName())
                .comments(comments)
                .build();

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
