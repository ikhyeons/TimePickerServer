package com.ikhyeons.tp.time_picker_server.friendRequest.friendRequestDTO;


import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import lombok.Data;

@Data
public class FriendRequestDTO {
    private Long friendRequestId;

    private Member requester;

    private Member receiver;

}
