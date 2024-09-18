package com.ikhyeons.tp.time_picker_server.friendRequest.service;

import com.ikhyeons.tp.time_picker_server.friend.repository.FriendRepository;
import com.ikhyeons.tp.time_picker_server.friend.service.FriendService;
import com.ikhyeons.tp.time_picker_server.friendRequest.repository.FriendRequestRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@DisplayName("프렌드리퀘스트 테스트")
class FriendRequestServiceTest {

    @Autowired
    private FriendService friendService;
    @Autowired
    private FriendRepository friendRepository;
    @Autowired
    private FriendRequestRepository friendRequestRepository;
    @Autowired
    private FriendRequestService friendRequestService;

    @Test
    @DisplayName("친추")
    void 친추() throws Exception{
        //given

        //when

        //then

    }


    @Test
    @DisplayName("친구수락")
    void 친구수락() throws Exception{
        //given

        //when

        //then

    }

    @Test
    @DisplayName("친구거절")
    void 친구거절() throws Exception{
        //given
        
        //when

        //then

    }

    @Test
    @DisplayName("요청삭제")
    void 요청삭제() throws Exception{
        //given
        
        //when
        
        //then
        
    }
}