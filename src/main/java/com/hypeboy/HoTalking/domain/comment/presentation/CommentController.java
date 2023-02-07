package com.hypeboy.HoTalking.domain.comment.presentation;

import com.hypeboy.HoTalking.domain.comment.presentation.dto.request.CreateCommentRequest;
import com.hypeboy.HoTalking.domain.comment.service.CommentService;
import com.hypeboy.HoTalking.global.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping(value = "/create")
    public Response createComment(@RequestBody CreateCommentRequest request) {
        return commentService.createComment(request);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Response deleteComment(@PathVariable Long id) {
        return commentService.deleteComment(id);
    }

}