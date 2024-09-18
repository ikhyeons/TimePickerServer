package com.ikhyeons.tp.time_picker_server.friend.repository;

import com.ikhyeons.tp.time_picker_server.friend.entity.Friend;
import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import com.ikhyeons.tp.time_picker_server.rDay.entity.RDay;
import com.ikhyeons.tp.time_picker_server.request.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FriendRepository extends JpaRepository<Friend, Long> {
    public List<Friend> findAllByOne(Member member);
}
