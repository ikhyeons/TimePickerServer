package com.ikhyeons.tp.time_picker_server.member.service;

import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import com.ikhyeons.tp.time_picker_server.member.entity.Role;
import com.ikhyeons.tp.time_picker_server.member.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Transactional
@DisplayName("멤버 테스트")
class MemberServiceTest {
    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberRepository memberRepository;
    @Test
    @DisplayName("회원가입")
    void 회원가입() throws Exception{
        //given
        Member member = Member.createMemberIkhyeon();
        //when
        memberService.join(member);
        //then
        assertThat(memberRepository.findById(member.getMemberId()).isPresent()).isTrue();
    }

    @Test
    @DisplayName("중복확인")
    void 중복확인() throws Exception{
        //given
        Member member = Member.createMemberIkhyeon();
        memberService.join(member);
        //when
        boolean isDuplicated = memberService.checkDuplication("skantrkwl789");
        //then
        assertThat(isDuplicated).isTrue();
    }
}