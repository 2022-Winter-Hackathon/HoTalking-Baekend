package com.hypeboy.HoTalking.domain.issue.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hypeboy.HoTalking.domain.member.domain.entity.Member;
import com.hypeboy.HoTalking.domain.post.domain.entity.Post;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String issueName;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member author;

    @OneToMany(mappedBy = "issue", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Post> issuePost = new HashSet<>();

    public void addPost(Post post) {
        post.setIssue(this);
        issuePost.add(post);
    }

    public void removePost(Post post) {
        issuePost.remove(post);
    }

}
