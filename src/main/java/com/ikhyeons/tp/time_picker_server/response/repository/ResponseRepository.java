package com.ikhyeons.tp.time_picker_server.response.repository;

import com.ikhyeons.tp.time_picker_server.response.entity.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Long> {
}
