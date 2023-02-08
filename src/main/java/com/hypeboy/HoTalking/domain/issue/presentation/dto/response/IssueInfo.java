package com.hypeboy.HoTalking.domain.issue.presentation.dto.response;

import com.hypeboy.HoTalking.domain.member.presentation.dto.response.profile.MemberInfo;
import com.hypeboy.HoTalking.domain.post.domain.entity.Post;
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

    private String author;

}