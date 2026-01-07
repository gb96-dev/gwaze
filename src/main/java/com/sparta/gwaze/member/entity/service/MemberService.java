package com.sparta.gwaze.member.service;

import com.sparta.gwaze.member.dto.MemberCreateRequest;
import com.sparta.gwaze.member.entity.Member;
import com.sparta.gwaze.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Long createMember(MemberCreateRequest request) {
        Member member = new Member(request.getName());
        return memberRepository.save(member).getId();
    }
}