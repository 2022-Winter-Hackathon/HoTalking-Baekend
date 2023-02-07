package com.hypeboy.HoTalking.domain.post.entity;

import com.hypeboy.HoTalking.domain.file.File;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Optional;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private String content;

    @OneToOne
    @JoinColumn(name = "file_id")
    private File file;

}
