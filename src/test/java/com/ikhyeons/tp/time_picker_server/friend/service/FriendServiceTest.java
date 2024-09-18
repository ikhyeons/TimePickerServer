package com.ikhyeons.tp.time_picker_server.friend.service;

import com.ikhyeons.tp.time_picker_server.friend.entity.Friend;
import com.ikhyeons.tp.time_picker_server.friend.repository.FriendRepository;
import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import com.ikhyeons.tp.time_picker_server.member.entity.Role;
import com.ikhyeons.tp.time_picker_server.member.repository.MemberRepository;
import com.ikhyeons.tp.time_picker_server.member.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@DisplayName("프렌드 테스트")
class FriendServiceTest {
    @Autowired
    private FriendService friendService;
    @Autowired
    private FriendRepository friendRepository;


    @Test
    @DisplayName("친추")
    void fairFriend() throws Exception{
        //given
        Member memberOne = Member.createMemberIkhyeon();
        Member memberTwo = Member.builder().mid("sss123").name("장민욱").role("user").password("jang123").build();
        Friend friend = Friend.builder().one(memberOne).two(memberTwo).build();
        Friend friendFair = Friend.builder().one(memberTwo).two(memberOne).build();
        //when
        Friend fr1 = friendService.fairFriend(friend);
        Friend fr2 = friendService.fairFriend(friendFair);
        //then
        assertThat(friendRepository.findById(fr1.getFriendId()).isPresent()).isTrue();
        assertThat(friendRepository.findById(fr2.getFriendId()).isPresent()).isTrue();
    }

    @Test
    @DisplayName("친삭")
    void removeFriend() {
    }
}