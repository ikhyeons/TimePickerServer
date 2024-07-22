package com.ikhyeons.tp.time_picker_server.team.service;

import com.ikhyeons.tp.time_picker_server.member.service.MemberService;
import com.ikhyeons.tp.time_picker_server.team.entity.Team;
import com.ikhyeons.tp.time_picker_server.team.repository.TeamRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class TeamServiceTest {
    @Autowired
    private MemberService memberService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private TeamRepository teamRepository;
    @Test
    @DisplayName("팀 생성")
    void 팀생성() throws Exception {
        //given
        Team team = Team.createTeamYM();
        //when
        Team savedTeam = teamService.saveTeam(team);
        //then
        assertThat(teamRepository.findById(savedTeam.getTeamId()).isPresent()).isTrue();
    }
    
    @Test
    @DisplayName("팀 삭제")
    void 팀삭제() throws Exception{
        //given
        Team team = Team.createTeamYM();
        Team savedTeam = teamService.saveTeam(team);
        //when
        teamService.deleteTeam(savedTeam);
        //then
        assertThat(teamRepository.findById(savedTeam.getTeamId()).isPresent()).isFalse();
    }
}