package com.hypeboy.HoTalking.domain.comment.domain.repository;

import com.hypeboy.HoTalking.domain.comment.domain.entity.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {



}