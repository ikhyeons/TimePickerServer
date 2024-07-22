package com.ikhyeons.tp.time_picker_server.teamMember.service;

import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import com.ikhyeons.tp.time_picker_server.team.entity.Team;
import com.ikhyeons.tp.time_picker_server.teamMember.entity.TeamMember;
import com.ikhyeons.tp.time_picker_server.teamMember.repository.TeamMemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@DisplayName("팀멤버 테스트")
class TeamMemberServiceTest {
    @Autowired
    private TeamMemberRepository teamMemberRepository;
    @Autowired
    private TeamMemberService teamMemberService;
    @Test
    @DisplayName("팀원 추가")
    void 팀원추가() throws Exception{
        //given
        Member member = Member.createMemberIkhyeon();
        Team team = Team.createTeamYM();
        TeamMember teamMember = TeamMember.builder().team(team).member(member).build();
        //when
        TeamMember savedTeamMember = teamMemberService.addMember(teamMember);
        //then
        assertThat(teamMemberRepository.findById(savedTeamMember.getTeamMemberId()).isPresent()).isTrue();
        assertThat(teamMemberRepository.findById(savedTeamMember.getTeamMemberId()).get().getMember()).isEqualTo(member);
        assertThat(teamMemberRepository.findById(savedTeamMember.getTeamMemberId()).get().getTeam()).isEqualTo(team);
    }
    @Test
    @DisplayName("팀원 삭제")
    void 팀원삭제() throws Exception{
        //given
        Member member = Member.createMemberIkhyeon();
        Team team = Team.createTeamYM();
        TeamMember teamMember = TeamMember.builder().team(team).member(member).build();
        TeamMember savedTeamMember = teamMemberService.addMember(teamMember);
        //when
        teamMemberService.removeTeamMember(teamMember);
        //then
        assertThat(teamMemberRepository.findById(savedTeamMember.getTeamMemberId()).isPresent()).isFalse();
    }
}