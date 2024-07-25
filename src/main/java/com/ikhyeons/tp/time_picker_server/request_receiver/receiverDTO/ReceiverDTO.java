package com.ikhyeons.tp.time_picker_server.request_receiver.receiverDTO;

import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import com.ikhyeons.tp.time_picker_server.request.entity.Request;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class ReceiverDTO {
    private Long requestReceiverId;
    private Long requestId;
    private Long memberId;

}
