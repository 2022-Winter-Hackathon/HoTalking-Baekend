package com.hypeboy.HoTalking.domain.issue.service;

import com.hypeboy.HoTalking.domain.issue.entity.Issue;
import com.hypeboy.HoTalking.domain.issue.entity.dto.request.AddIssueRequest;
import com.hypeboy.HoTalking.domain.issue.repository.IssueRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IssueService {

    private final IssueRepository issueRepository;

    public ResponseEntity<?> addIssue(AddIssueRequest request) {
        Issue issue = Issue.builder()
                .issueName(request.getIssueName())
                .build();
        issueRepository.save(issue);
        return ResponseEntity.ok().body("성공적으로 저장되었습니다");
    }


}
