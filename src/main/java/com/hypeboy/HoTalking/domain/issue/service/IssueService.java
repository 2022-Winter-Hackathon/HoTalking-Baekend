package com.hypeboy.HoTalking.domain.issue.service;

import com.hypeboy.HoTalking.domain.issue.entity.Issue;
import com.hypeboy.HoTalking.domain.issue.entity.dto.request.AddIssueRequest;
import com.hypeboy.HoTalking.domain.issue.entity.dto.request.ro.IssueRo;
import com.hypeboy.HoTalking.domain.issue.repository.IssueRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<IssueRo> getIssue() {
        List<Issue> issues = issueRepository.findAll();

        List<IssueRo> issueRo = issues.stream().map(it -> new IssueRo(it.getIssueName())).collect(Collectors.toList());

        return issueRo;
    }


    public ResponseEntity<?> deleteIssue(Long id) {
        issueRepository.deleteById(id);
        return ResponseEntity.ok("성공적으로 삭제 되었습니다");
    }


}
