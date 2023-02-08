package com.hypeboy.HoTalking.domain.member.presentation.dto.response.profile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
public class PostInfo {

    private long id;

    private String title;

    private String content;

    //private List<byte[]> byteImageList;


    private List<Long> imageIdList;

    private LocalDateTime createdDate;

}