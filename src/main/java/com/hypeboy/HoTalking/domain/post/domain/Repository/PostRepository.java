package com.hypeboy.HoTalking.domain.post.domain.Repository;

import com.hypeboy.HoTalking.domain.post.domain.entity.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByRole(Pageable pageable, String Role);

}
