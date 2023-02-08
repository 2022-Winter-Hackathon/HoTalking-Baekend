package com.hypeboy.HoTalking.domain.issue.controller;

import com.hypeboy.HoTalking.domain.issue.entity.Issue;
import com.hypeboy.HoTalking.domain.issue.service.IssueService;
import com.hypeboy.HoTalking.domain.issue.entity.dto.request.AddIssueRequest;
import com.hypeboy.HoTalking.domain.member.domain.entity.Member;
import com.hypeboy.HoTalking.global.annotation.AuthToken;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/issue")
public class IssueController {

    private final IssueService issueService;

    @PostMapping("/add")
    public ResponseEntity<?> addIssue(@RequestBody @Validated AddIssueRequest request) {
        return issueService.addIssue(request);
    }

    @GetMapping("/get")
    public Issue getIssue() {
        return issueService.getIssue();
    }

    @AuthToken
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteIssue(@RequestAttribute Member member, @PathVariable ("id") Long id) {
        return issueService.deleteIssue(member, id);
    }

}