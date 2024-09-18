package com.ikhyeons.tp.time_picker_server.friend.friendDTO;


import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import com.ikhyeons.tp.time_picker_server.rDay.entity.Day;
import com.ikhyeons.tp.time_picker_server.request.entity.Request;
import com.ikhyeons.tp.time_picker_server.response.responseDTO.ResponseDTO;
import lombok.Data;

import java.util.List;

@Data
public class FriendDTO {
    private Long friendId;

    private Member one;

    private Member two;

}
