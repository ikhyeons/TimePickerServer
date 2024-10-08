package com.ikhyeons.tp.time_picker_server.member.service;

import com.ikhyeons.tp.time_picker_server.member.entity.Member;

public interface IMemberService {
    public Member join(Member member);

    public Member findMember(String mid);
    public boolean checkDuplication(String mid);
}
