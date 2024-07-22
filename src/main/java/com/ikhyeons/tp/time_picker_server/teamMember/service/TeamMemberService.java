package com.ikhyeons.tp.time_picker_server.teamMember.service;

import com.ikhyeons.tp.time_picker_server.member.repository.MemberRepository;
import com.ikhyeons.tp.time_picker_server.team.entity.Team;
import com.ikhyeons.tp.time_picker_server.team.repository.TeamRepository;
import com.ikhyeons.tp.time_picker_server.teamMember.entity.TeamMember;
import com.ikhyeons.tp.time_picker_server.teamMember.repository.TeamMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamMemberService {
    private final TeamRepository teamRepository;
    private final MemberRepository memberRepository;
    private final TeamMemberRepository teamMemberRepository;
    public TeamMember addMember(TeamMember teamMember){
        return teamMemberRepository.save(teamMember);
    }

    public boolean removeTeamMember(TeamMember teamMember){
        try{
            teamMemberRepository.delete(teamMember);
           return true;
        } catch (Exception e){
            return false;
        }
    }
}
