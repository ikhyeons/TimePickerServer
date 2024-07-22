package com.ikhyeons.tp.time_picker_server.request_receiver.repository;

import com.ikhyeons.tp.time_picker_server.request_receiver.entity.RequestReceiver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestReceiverRepository extends JpaRepository<RequestReceiver, Long> {
}
