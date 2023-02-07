package com.hypeboy.HoTalking.domain.post.Repository;

import com.hypeboy.HoTalking.domain.post.entity.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByRole(Pageable pageable, String Role);

}
