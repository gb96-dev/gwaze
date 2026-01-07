package com.sparta.gwaze.gwaze.entity;

import com.sparta.gwaze.member.entity.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "gwazes")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Gwaze {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public Gwaze(String content, Member member) {
        this.content = content;
        this.member = member;
    }
}