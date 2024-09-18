package com.ikhyeons.tp.time_picker_server.friendRequest.repository;

import com.ikhyeons.tp.time_picker_server.friendRequest.entity.FriendRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FriendRequestRepository extends JpaRepository<FriendRequest, Long> {
    //public List<FriendRequest> findAllByOne(Member member);
}
