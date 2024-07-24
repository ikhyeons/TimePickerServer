package com.ikhyeons.tp.time_picker_server.member.controller;

import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import com.ikhyeons.tp.time_picker_server.member.entity.Role;
import com.ikhyeons.tp.time_picker_server.member.memberDTO.MemberDTO;
import com.ikhyeons.tp.time_picker_server.member.service.MemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    @GetMapping("/member/checkDuplicate")
    public boolean checkDuplicate(@RequestParam("mid") String mid){
        boolean isDuplicated = memberService.checkDuplication(mid);
        return isDuplicated;
    }

    //수정해야 함.
    @GetMapping("/member/login")
    public Object login(@RequestBody MemberDTO postData){
        boolean isLogin = memberService.login(postData.getMid(), postData.getPassword());
        return isLogin;
    }

    @PostMapping("/member/join")
    public Object join(@RequestBody MemberDTO postData){
        Member member = Member.builder().mid(postData.getMid()).password(postData.getPassword()).name(postData.getName()).role(Role.USER).build();
        try{
            Member savedMember = memberService.join(member);
            return savedMember.getMemberId();
        } catch (Exception e){
            throw  new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
