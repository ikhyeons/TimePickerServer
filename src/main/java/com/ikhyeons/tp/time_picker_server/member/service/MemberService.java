package com.ikhyeons.tp.time_picker_server.member.service;

import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import com.ikhyeons.tp.time_picker_server.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService implements IMemberService{
    private final MemberRepository memberRepository;

    @Override
    public Member join(Member member){
        return memberRepository.save(member);
    }

    @Override
    public boolean checkDuplication (String mid){
        return memberRepository.findOneByMid(mid).isPresent();
    }
}
