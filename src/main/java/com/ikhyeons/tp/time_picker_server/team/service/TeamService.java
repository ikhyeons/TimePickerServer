package com.ikhyeons.tp.time_picker_server.team.service;

import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import com.ikhyeons.tp.time_picker_server.member.repository.MemberRepository;
import com.ikhyeons.tp.time_picker_server.team.entity.Team;
import com.ikhyeons.tp.time_picker_server.team.repository.TeamRepository;
import com.ikhyeons.tp.time_picker_server.team.teamDTO.TeamDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;
    private final MemberRepository memberRepository;
    public Team saveTeam(Team team){
        return teamRepository.save(team);
    }

    public List<TeamDTO> getTeamLIst(Long memberId){
        Member member = memberRepository.findById(memberId).get();
        List<Team> teamList = teamRepository.findAllByMember(member);
        List<TeamDTO> result = teamList.stream().map(data->data.toDTO()).collect(Collectors.toList());
        return result;
    }
    public boolean deleteTeam(Team team){
        try{
           teamRepository.delete(team);
           return true;
        } catch (Exception e){
            return false;
        }
    }
}
