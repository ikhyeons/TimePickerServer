package com.ikhyeons.tp.time_picker_server.request.repository;

import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import com.ikhyeons.tp.time_picker_server.request.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
    public List<Request> findAllByMember(Member member);
}
