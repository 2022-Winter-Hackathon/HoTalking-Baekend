package com.hypeboy.HoTalking.domain.comment.service;

import com.hypeboy.HoTalking.domain.comment.domain.entity.Comment;
import com.hypeboy.HoTalking.domain.comment.domain.repository.CommentRepository;
import com.hypeboy.HoTalking.domain.comment.exception.CommentNotFoundException;
import com.hypeboy.HoTalking.domain.comment.presentation.dto.request.CreateCommentRequest;
import com.hypeboy.HoTalking.domain.member.domain.entity.Member;
import com.hypeboy.HoTalking.domain.member.domain.repository.MemberRepository;
import com.hypeboy.HoTalking.domain.post.Repository.PostRepository;
import com.hypeboy.HoTalking.domain.post.entity.Post;
import com.hypeboy.HoTalking.domain.post.exception.PostNotFoundException;
import com.hypeboy.HoTalking.global.lib.jwt.JwtUtil;
import com.hypeboy.HoTalking.global.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final JwtUtil jwtUtil;

    private final MemberRepository memberRepository;

    private final CommentRepository commentRepository;

    private final PostRepository postRepository;

    public Response createComment(CreateCommentRequest request) {

        //Member member = jwtUtil.getMemberByToken(request.getToken());

        Post post = postRepository.findById(request.getPost_id())
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);

        Comment comment = Comment.builder()
         //       .author(member)
                .post(post)
                .content(request.getContent())
                .build();
        commentRepository.save(comment);

        post.addComment(comment);
        postRepository.save(post);

        //member.addComment(comment);
        //memberRepository.save(member);

        return new Response(
                HttpStatus.OK,
                "댓글 생성 완료"
        );
    }

    public Response deleteComment(Long id) {

        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> CommentNotFoundException.EXCEPTION);

        Member member = comment.getAuthor();

        Post post = comment.getPost();

        post.removeComment(comment);
        postRepository.save(post);

        member.removeComment(comment);
        memberRepository.save(member);

        commentRepository.deleteById(id);

        return new Response(
                HttpStatus.OK,
                "댓글 삭제 완료"
        );
    }

}