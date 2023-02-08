package com.hypeboy.HoTalking.domain.issue.controller.dto;

import com.hypeboy.HoTalking.domain.member.presentation.dto.response.profile.MemberInfo;
import com.hypeboy.HoTalking.domain.post.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IssueInfo {

    private long id;

    private String title;

    private MemberInfo memberInfo;

    private Set<Post> issuePost;

}