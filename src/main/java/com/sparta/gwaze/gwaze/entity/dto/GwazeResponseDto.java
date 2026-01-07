package com.sparta.gwaze.gwaze.dto;

import com.sparta.gwaze.gwaze.entity.Gwaze;
import lombok.Getter;

@Getter
public class GwazeResponseDto {
    private Long id;
    private String content;
    private String memberName; // 이 정보를 담을 때 Member 쿼리가 나갑니다.

    public GwazeResponseDto(Gwaze gwaze) {
        this.id = gwaze.getId();
        this.content = gwaze.getContent();
        // 지연 로딩된 Member 객체에 접근하여 실제 이름을 가져옴 (이때 2번째 쿼리 발생)
        this.memberName = gwaze.getMember().getName();
    }
}