package com.ikhyeons.tp.time_picker_server.team.repository;

import com.ikhyeons.tp.time_picker_server.team.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
}
