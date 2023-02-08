package com.hypeboy.HoTalking.domain.member.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hypeboy.HoTalking.domain.comment.domain.entity.Comment;
import com.hypeboy.HoTalking.domain.issue.domain.entity.Issue;
import com.hypeboy.HoTalking.domain.member.domain.enums.Role;
import com.hypeboy.HoTalking.domain.post.domain.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String uniqueId;

    private int grade;

    private int room;

    private int number;

    private String name;

    private String profileImage;

    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder.Default
    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    private Set<Issue> issueList = new HashSet<>();

    @Builder.Default
    @JsonManagedReference
    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    private Set<Post> postList = new HashSet<>();

    @Builder.Default
    @JsonManagedReference
    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    private Set<Comment> commentList = new HashSet<>();

    public void addIssue(Issue issue) {
        issue.setAuthor(this);
        issueList.add(issue);
    }

    public void removeIssue(Issue issue) {
        issueList.remove(issue);
    }

    public void addPost(Post post) {
        post.setAuthor(this);
        postList.add(post);
    }

    public void removePost(Post post) {
        postList.remove(post);
    }

    public void addComment(Comment comment) {
        comment.setAuthor(this);
        commentList.add(comment);
    }

    public void removeComment(Comment comment) {
        commentList.remove(comment);
    }

}