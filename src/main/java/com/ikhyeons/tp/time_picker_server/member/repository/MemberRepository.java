package com.ikhyeons.tp.time_picker_server.member.repository;

import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  MemberRepository extends JpaRepository<Member, Long> {
    public Optional<Member> findOneByMid(String mid);
}
