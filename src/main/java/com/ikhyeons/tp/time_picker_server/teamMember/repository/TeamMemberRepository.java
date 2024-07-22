package com.ikhyeons.tp.time_picker_server.teamMember.repository;

import com.ikhyeons.tp.time_picker_server.team.entity.Team;
import com.ikhyeons.tp.time_picker_server.teamMember.entity.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {
}
