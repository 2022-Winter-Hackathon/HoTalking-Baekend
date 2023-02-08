package com.hypeboy.HoTalking.domain.issue.service;

import com.hypeboy.HoTalking.domain.issue.entity.Issue;
import com.hypeboy.HoTalking.domain.issue.entity.dto.request.AddIssueRequest;
import com.hypeboy.HoTalking.domain.issue.exception.IssueNotFoundException;
import com.hypeboy.HoTalking.domain.issue.repository.IssueRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IssueService {

    private final IssueRepository issueRepository;

    public ResponseEntity<?> save(Issue issue) {
        issueRepository.save(issue);
        return ResponseEntity.ok().body("issue 저장 성공");
    }

    public ResponseEntity<?> addIssue(AddIssueRequest request) {
        Issue issue = Issue.builder()
                .issueName(request.getIssueName())
                .build();
        issueRepository.save(issue);
        return ResponseEntity.ok().body("성공적으로 저장되었습니다");
    }

    public Issue getIssue() {
        return issueRepository.findById(1L)
                .orElseThrow(() -> IssueNotFoundException.EXCEPTION);
    }


    public ResponseEntity<?> deleteIssue(Long id) {
        issueRepository.deleteById(id);
        return ResponseEntity.ok("성공적으로 삭제 되었습니다");
    }

}