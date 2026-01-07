package com.sparta.gwaze.member.repository;

import com.sparta.gwaze.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}