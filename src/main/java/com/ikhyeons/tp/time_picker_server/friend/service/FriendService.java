package com.ikhyeons.tp.time_picker_server.friend.service;


import com.ikhyeons.tp.time_picker_server.friend.entity.Friend;
import com.ikhyeons.tp.time_picker_server.friend.friendDTO.FriendDTO;
import com.ikhyeons.tp.time_picker_server.friend.repository.FriendRepository;
import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import com.ikhyeons.tp.time_picker_server.rDate.entity.RDate;
import com.ikhyeons.tp.time_picker_server.rDate.repository.RDateRepository;
import com.ikhyeons.tp.time_picker_server.request.entity.Request;
import com.ikhyeons.tp.time_picker_server.request.requestDTO.RequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FriendService {
    private final FriendRepository friendRepository;

    @Transactional
    public Friend fairFriend(Friend friend){
        return friendRepository.save(friend);
    }

    public List<FriendDTO> getFriendList(Member member){
        List<Friend> friendList = friendRepository.findAllByOne(member);
        List<FriendDTO> friendDTO = friendList.stream().map(data->data.toDTO()).collect(Collectors.toList());
        return friendDTO;
    }

    @Transactional
    public boolean removeFriend(Friend friend){
        try{
            friendRepository.delete(friend);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
