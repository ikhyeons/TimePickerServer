package com.ikhyeons.tp.time_picker_server.rDay.repository;

import com.ikhyeons.tp.time_picker_server.rDay.entity.RDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RDayRepository  extends JpaRepository<RDay, Long> {
}
