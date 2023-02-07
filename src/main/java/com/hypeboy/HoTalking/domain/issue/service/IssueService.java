package com.hypeboy.HoTalking.domain.issue.service;

import com.hypeboy.HoTalking.domain.issue.entity.Issue;
import com.hypeboy.HoTalking.domain.issue.entity.dto.request.AddIssueRequest;
import com.hypeboy.HoTalking.domain.issue.entity.dto.request.ro.IssueRo;
import com.hypeboy.HoTalking.domain.issue.repository.IssueRepository;
import com.hypeboy.HoTalking.global.error.exception.IssueNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public IssueRo getIssue() {
        Issue issueName = issueRepository.findById(1L).orElseThrow();

        return new IssueRo(issueName.getIssueName());
    }


    public ResponseEntity<?> deleteIssue(Long id) {
        issueRepository.deleteById(id);
        return ResponseEntity.ok("성공적으로 삭제 되었습니다");
    }


}
