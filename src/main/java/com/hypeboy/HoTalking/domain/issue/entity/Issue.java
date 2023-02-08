package com.hypeboy.HoTalking.domain.issue.entity;

import com.hypeboy.HoTalking.domain.post.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String issueName;

    @OneToMany(mappedBy = "issue", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Post> issuePost = new HashSet<>();

    public void addPost(Post post) {
        post.setIssue(this);
        issuePost.add(post);
    }

    public void removePost(Post post) {
        issuePost.remove(post);
    }

}
