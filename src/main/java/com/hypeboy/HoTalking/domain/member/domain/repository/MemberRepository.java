package com.hypeboy.HoTalking.domain.member.domain.repository;

import com.hypeboy.HoTalking.domain.member.domain.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, String> {

    boolean existsByGradeAndNumberAndRoom(int grade, int number, int room);
}