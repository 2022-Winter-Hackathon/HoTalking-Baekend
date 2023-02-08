package com.hypeboy.HoTalking.domain.member.service;

import com.hypeboy.HoTalking.domain.auth.presentation.dto.api.DOpenApiDto;
import com.hypeboy.HoTalking.domain.auth.presentation.dto.api.DodamInfoDto;
import com.hypeboy.HoTalking.domain.member.domain.entity.Member;
import com.hypeboy.HoTalking.domain.member.domain.repository.MemberRepository;
import com.hypeboy.HoTalking.domain.member.presentation.dto.response.profile.MemberInfo;
import com.hypeboy.HoTalking.domain.member.presentation.dto.response.MemberProfileResponseDto;
import com.hypeboy.HoTalking.domain.member.presentation.dto.response.profile.PostInfo;
import com.hypeboy.HoTalking.domain.post.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Member save(DOpenApiDto dOpenApiDto) {
        DodamInfoDto data = dOpenApiDto.getDodamInfoData();
        Member member = DodamInfoDto.toEntity(data);
        if(isExisted(member)) {
            return member;
        }

        return memberRepository.save(member);
    }

    public MemberInfo getMemberInfo(final Member member) {
        return MemberInfo.builder()
                .id(member.getId())
                .uniqueId(member.getUniqueId())
                .name(member.getName())
                .role(member.getRole())
                .email(member.getEmail())
                .profileImage(member.getProfileImage())
                .grade(member.getGrade())
                .room(member.getRoom())
                .number(member.getNumber())
                .build();
    }

    public MemberProfileResponseDto getMyInfo(final Member member) {

        List<PostInfo> postInfoList = new ArrayList<>();
        Set<Post> postSet = member.getPostList();

        for(Post po : postSet) {

            /*
            List<byte[]> byteImageList = new ArrayList<>();
            for(int i = 1; i<=po.getImages().size(); i++) {
                byte[] byteImage = postService.getImage(i);
                byteImageList.add(byteImage);
            }
            */

            List<Long> imageIdList = new ArrayList<>();
            for(long i = 1; i<=po.getImages().size(); i++)
                imageIdList.add(i);

            PostInfo postInfo = PostInfo.builder()
                    .id(po.getId())
                    .title(po.getTitle())
                    .content(po.getContent())
                    .imageIdList(imageIdList)
                    .createdDate(po.getCreatedDate())
                    .build();
            postInfoList.add(postInfo);
        }

        MemberInfo memberInfo = MemberInfo.builder()
                .id(member.getId())
                .uniqueId(member.getUniqueId())
                .grade(member.getGrade())
                .room(member.getRoom())
                .number(member.getNumber())
                .name(member.getName())
                .profileImage(member.getProfileImage())
                .email(member.getEmail())
                .role(member.getRole())
                .build();

        return MemberProfileResponseDto.builder()
                .myMemberInfo(memberInfo)
                .myCommentInfo(member.getCommentList())
                .myPostInfo(postInfoList)
                .build();
        /*
        id, 제목, 내용, 생성일자, 이미지
        */
    }

    @Transactional
    protected boolean isExisted(Member member) {
        return memberRepository.existsByGradeAndNumberAndRoom(member.getGrade(), member.getNumber(), member.getRoom());
    }

}