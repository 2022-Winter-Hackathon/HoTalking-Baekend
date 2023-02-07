package com.hypeboy.HoTalking.domain.issue.controller;

import com.hypeboy.HoTalking.domain.issue.service.IssueService;
import com.hypeboy.HoTalking.domain.issue.entity.dto.request.AddIssueRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/issue")
public class IssueController {

    private final IssueService issueService;

    @PostMapping("/add")
    public ResponseEntity<?> issueAdd(@RequestBody @Validated AddIssueRequest request) {
        return issueService.addIssue(request);
    }

}
