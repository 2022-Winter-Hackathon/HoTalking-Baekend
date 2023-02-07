package com.hypeboy.HoTalking.domain.issue.repository;

import com.hypeboy.HoTalking.domain.issue.entity.Issue;
import com.hypeboy.HoTalking.domain.issue.entity.dto.request.ro.IssueRo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {


}
