package com.sparta.gwaze.gwaze.controller;

import com.sparta.gwaze.gwaze.dto.GwazeRequestDto;
import com.sparta.gwaze.gwaze.dto.GwazeResponseDto;
import com.sparta.gwaze.gwaze.service.GwazeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class GwazeController {
    private final GwazeService gwazeService;

    // 과제 등록
    @PostMapping("/gwazes")
    public String create(@RequestBody GwazeRequestDto request) {
        return gwazeService.save(request);
    }

    // 과제 단건 조회 (과제 스크린샷 찍을 대상)
    @GetMapping("/gwazes/{id}")
    public GwazeResponseDto getGwaze(@PathVariable Long id) {
        return gwazeService.getGwaze(id);
    }
}