package com.hypeboy.HoTalking.domain.comment.domain.repository;

import com.hypeboy.HoTalking.domain.comment.domain.entity.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {

    List<Comment> findByPost_Id(Long id);

}