package com.hypeboy.HoTalking.domain.issue.service;

import com.hypeboy.HoTalking.domain.comment.exception.MemberNotMatchExceptioin;
import com.hypeboy.HoTalking.domain.issue.entity.Issue;
import com.hypeboy.HoTalking.domain.issue.entity.dto.request.AddIssueRequest;
import com.hypeboy.HoTalking.domain.issue.exception.IssueNotFoundException;
import com.hypeboy.HoTalking.domain.issue.exception.NoPermissionException;
import com.hypeboy.HoTalking.domain.issue.repository.IssueRepository;
import com.hypeboy.HoTalking.domain.member.domain.entity.Member;
import com.hypeboy.HoTalking.domain.member.domain.enums.Role;
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

    public ResponseEntity<?> addIssue(final Member member, AddIssueRequest request) {
        Role role = member.getRole();

        if(role==Role.TEACHER || role==Role.ADMIN) {
            throw new NoPermissionException();
        }

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

    public ResponseEntity<?> deleteIssue(final Member member, Long id) {
        Issue issue = getIssue();
        Member author = issue.getAuthor();

        if(member.getId().equals(author.getId())) {
            throw new MemberNotMatchExceptioin();
        }

        member.removeIssue(issue);

        issueRepository.deleteById(id);

        return ResponseEntity.ok("성공적으로 삭제 되었습니다");
    }

}