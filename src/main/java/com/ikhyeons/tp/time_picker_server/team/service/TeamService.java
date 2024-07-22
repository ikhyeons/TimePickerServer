package com.ikhyeons.tp.time_picker_server.team.service;

import com.ikhyeons.tp.time_picker_server.team.entity.Team;
import com.ikhyeons.tp.time_picker_server.team.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;
    public Team saveTeam(Team team){
        return teamRepository.save(team);
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
