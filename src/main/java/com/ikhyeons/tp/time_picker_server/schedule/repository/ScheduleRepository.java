package com.ikhyeons.tp.time_picker_server.schedule.repository;

import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import com.ikhyeons.tp.time_picker_server.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
