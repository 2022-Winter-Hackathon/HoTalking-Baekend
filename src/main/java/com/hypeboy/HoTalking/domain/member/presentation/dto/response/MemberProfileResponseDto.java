package com.hypeboy.HoTalking.domain.member.presentation.dto.response;

import com.hypeboy.HoTalking.domain.comment.domain.entity.Comment;
import com.hypeboy.HoTalking.domain.member.presentation.dto.response.profile.MemberInfo;
import com.hypeboy.HoTalking.domain.member.presentation.dto.response.profile.PostInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@NoArgsConstructor @AllArgsConstructor
@Builder
@Getter
public class MemberProfileResponseDto {

    private MemberInfo myMemberInfo;

    private Set<Comment> myCommentInfo;

    private List<PostInfo> myPostInfo;

}