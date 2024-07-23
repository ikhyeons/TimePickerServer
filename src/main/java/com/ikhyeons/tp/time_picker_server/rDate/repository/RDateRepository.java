package com.ikhyeons.tp.time_picker_server.rDate.repository;

import com.ikhyeons.tp.time_picker_server.rDate.entity.RDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RDateRepository extends JpaRepository<RDate, Long> {
}
