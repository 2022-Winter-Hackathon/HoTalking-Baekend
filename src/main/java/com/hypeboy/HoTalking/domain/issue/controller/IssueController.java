package com.hypeboy.HoTalking.domain.issue.controller;

import com.hypeboy.HoTalking.domain.issue.entity.dto.request.ro.IssueRo;
import com.hypeboy.HoTalking.domain.issue.service.IssueService;
import com.hypeboy.HoTalking.domain.issue.entity.dto.request.AddIssueRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
    @RequestMapping("/api/issue")
public class IssueController {

    private final IssueService issueService;

    @PostMapping("/add")
    public ResponseEntity<?> addIssue(@RequestBody @Validated AddIssueRequest request) {
        return issueService.addIssue(request);
    }

    @GetMapping("/get")
    public IssueRo getIssue() {
        return issueService.getIssue();
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteIssue(@PathVariable ("id") Long id) {
        return issueService.deleteIssue(id);
    }
}
