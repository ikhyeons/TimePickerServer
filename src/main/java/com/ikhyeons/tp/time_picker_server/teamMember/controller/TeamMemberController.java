package com.ikhyeons.tp.time_picker_server.teamMember.controller;


import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import com.ikhyeons.tp.time_picker_server.member.repository.MemberRepository;
import com.ikhyeons.tp.time_picker_server.team.entity.Team;
import com.ikhyeons.tp.time_picker_server.team.repository.TeamRepository;
import com.ikhyeons.tp.time_picker_server.teamMember.entity.TeamMember;
import com.ikhyeons.tp.time_picker_server.teamMember.repository.TeamMemberRepository;
import com.ikhyeons.tp.time_picker_server.teamMember.service.TeamMemberService;
import com.ikhyeons.tp.time_picker_server.teamMember.teamMemberDTO.TeamMemberDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TeamMemberController {
    private final TeamMemberService teamMemberService;
    private final TeamMemberRepository teamMemberRepository;
    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;

    @PostMapping("/teamMember")
    public Long addMemberToTeam(@RequestBody TeamMemberDTO postData){
        Member member = memberRepository.findById(postData.getMemberId()).get();
        Team team = teamRepository.findById(postData.getTeamId()).get();
        TeamMember teamMember = TeamMember.builder().member(member).team(team).build();
        TeamMember savedTeamMember = teamMemberService.addMember(teamMember);
        return savedTeamMember.getTeamMemberId();
    }

    @DeleteMapping("/teamMember")
    public boolean deleteMemberToTeam(@RequestParam Long teamMemberId){
        boolean isDeleted = teamMemberService.removeTeamMember(teamMemberRepository.findById(teamMemberId).get());
        return isDeleted;
    }

}
