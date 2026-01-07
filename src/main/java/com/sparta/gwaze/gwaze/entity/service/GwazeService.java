package com.sparta.gwaze.gwaze.service;

import com.sparta.gwaze.gwaze.dto.GwazeRequestDto;
import com.sparta.gwaze.gwaze.dto.GwazeResponseDto;
import com.sparta.gwaze.gwaze.entity.Gwaze;
import com.sparta.gwaze.gwaze.repository.GwazeRepository;
import com.sparta.gwaze.member.entity.Member;
import com.sparta.gwaze.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GwazeService {
    private final GwazeRepository gwazeRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public String save(GwazeRequestDto request) {
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("회원이 존재하지 않습니다."));

        Gwaze gwaze = new Gwaze(request.getContent(), member);
        gwazeRepository.save(gwaze);
        return "과제 저장 성공!";
    }

    @Transactional(readOnly = true)
    public GwazeResponseDto getGwaze(Long id) {
        Gwaze gwaze = gwazeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 과제가 없습니다."));

        return new GwazeResponseDto(gwaze);
    }
}