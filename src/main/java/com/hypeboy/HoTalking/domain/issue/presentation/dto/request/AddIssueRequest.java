package com.hypeboy.HoTalking.domain.issue.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddIssueRequest {

    @NotBlank(message = "이슈 내용이 필요합니다")
    private String issueName;

}
