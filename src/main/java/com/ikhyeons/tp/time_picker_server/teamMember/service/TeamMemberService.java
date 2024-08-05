package com.ikhyeons.tp.time_picker_server.teamMember.service;

import com.ikhyeons.tp.time_picker_server.member.repository.MemberRepository;
import com.ikhyeons.tp.time_picker_server.team.entity.Team;
import com.ikhyeons.tp.time_picker_server.team.repository.TeamRepository;
import com.ikhyeons.tp.time_picker_server.teamMember.entity.TeamMember;
import com.ikhyeons.tp.time_picker_server.teamMember.repository.TeamMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TeamMemberService {
    private final TeamRepository teamRepository;
    private final MemberRepository memberRepository;
    private final TeamMemberRepository teamMemberRepository;

    @Transactional
    public TeamMember addMember(TeamMember teamMember){
        return teamMemberRepository.save(teamMember);
    }

    @Transactional
    public boolean removeTeamMember(TeamMember teamMember){
        try{
            teamMemberRepository.delete(teamMember);
           return true;
        } catch (Exception e){
            return false;
        }
    }
}
