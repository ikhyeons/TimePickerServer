package com.ikhyeons.tp.time_picker_server.friendRequest.service;


import com.ikhyeons.tp.time_picker_server.friend.entity.Friend;
import com.ikhyeons.tp.time_picker_server.friend.friendDTO.FriendDTO;
import com.ikhyeons.tp.time_picker_server.friend.repository.FriendRepository;
import com.ikhyeons.tp.time_picker_server.friend.service.FriendService;
import com.ikhyeons.tp.time_picker_server.friendRequest.entity.FriendRequest;
import com.ikhyeons.tp.time_picker_server.friendRequest.repository.FriendRequestRepository;
import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FriendRequestService {
    private final FriendRepository friendRepository;
    private final FriendRequestRepository friendRequestRepository;
    private final FriendService friendService;

    @Transactional
    public FriendRequest requestFriend(FriendRequest friendRequest){
        return friendRequestRepository.save(friendRequest);
    }


    @Transactional
    public Friend acceptRequest(FriendRequest friendRequest){
        Friend friendFair1 = Friend.builder().one(friendRequest.getRequester()).two(friendRequest.getReceiver()).build();
        Friend friendFair2 = Friend.builder().one(friendRequest.getReceiver()).two(friendRequest.getRequester()).build();
        Friend fr1 = friendService.fairFriend(friendFair1);
        Friend fr2 =friendService.fairFriend(friendFair2);
        friendRequestRepository.delete(friendRequest);

        return fr2;
    }
    @Transactional
    public boolean rejectRequest(FriendRequest friendRequest){
        try{
            friendRequestRepository.delete(friendRequest);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Transactional
    public boolean removeFriendRequest(FriendRequest friendRequest){
        try{
            friendRequestRepository.delete(friendRequest);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
