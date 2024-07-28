package com.ikhyeons.tp.time_picker_server.request_receiver.repository;

import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import com.ikhyeons.tp.time_picker_server.request_receiver.entity.RequestReceiver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestReceiverRepository extends JpaRepository<RequestReceiver, Long> {
    public List<RequestReceiver> findAllByMember(Member member);
}
