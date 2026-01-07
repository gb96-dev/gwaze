package com.sparta.gwaze.member.controller;

import com.sparta.gwaze.member.dto.MemberCreateRequest;
import com.sparta.gwaze.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/members")
    public Long createMember(@RequestBody MemberCreateRequest request) {
        return memberService.createMember(request);
    }
}