package com.ikhyeons.tp.time_picker_server.team.controller;

import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import com.ikhyeons.tp.time_picker_server.member.repository.MemberRepository;
import com.ikhyeons.tp.time_picker_server.team.entity.Team;
import com.ikhyeons.tp.time_picker_server.team.repository.TeamRepository;
import com.ikhyeons.tp.time_picker_server.team.service.TeamService;
import com.ikhyeons.tp.time_picker_server.team.teamDTO.TeamDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class TeamController {
    private final TeamService teamService;
    private final TeamRepository teamRepository;
    private final MemberRepository memberRepository;

    @GetMapping("/team")
    public String team(){
        return "gd";
    }

    @PostMapping("/team")
    public Long createTeam(@RequestBody TeamDTO postData){
        Member maker =  memberRepository.findById(postData.getMemberId()).get();
        String teamName = postData.getName();
        Team team = Team.builder().member(maker).name(teamName).build();
        return teamService.saveTeam(team).getTeamId();
    }

    @DeleteMapping("/team")
    public boolean deleteTeam(@RequestParam("teamId") Long teamId){
        Team team = teamRepository.findById(teamId).get();
        boolean isDeleted = teamService.deleteTeam(team);
        return isDeleted;
    }
}
