package com.hypeboy.HoTalking.domain.post.entity;

import com.hypeboy.HoTalking.domain.comment.domain.entity.Comment;
import com.hypeboy.HoTalking.domain.file.File;
import com.hypeboy.HoTalking.domain.member.domain.entity.Member;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member author;

    private String content;

    @OneToOne
    @JoinColumn(name = "file_id")
    private File file;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

}