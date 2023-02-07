package com.hypeboy.HoTalking.domain.member.domain.repository;

import com.hypeboy.HoTalking.domain.member.domain.entity.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MemberRepository extends CrudRepository<Member, Long> {

    Optional<Member> findByUniqueId(String uniqueId);

    boolean existsByGradeAndNumberAndRoom(int grade, int number, int room);
}