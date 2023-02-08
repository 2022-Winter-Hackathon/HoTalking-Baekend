package com.hypeboy.HoTalking.domain.issue.domain.repository;

import com.hypeboy.HoTalking.domain.issue.domain.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {


}
