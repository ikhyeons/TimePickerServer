package com.ikhyeons.tp.time_picker_server.request.requestDTO;

import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import com.ikhyeons.tp.time_picker_server.rDate.rDateDTO.RDateDTO;
import com.ikhyeons.tp.time_picker_server.rDay.rDayDTO.RDayDTO;
import com.ikhyeons.tp.time_picker_server.request.entity.Type;
import com.ikhyeons.tp.time_picker_server.request_receiver.receiverDTO.ReceiverDTO;

import lombok.Data;


import java.util.List;

@Data
public class RequestDTO {

    private Long requestId;

    private Member member;

    private Type type;

    private String title;

    private String description;

    private String deadline;

    private List<ReceiverDTO> receiverList;

    private List<RDayDTO> dayList;

    private List<RDateDTO> dateList;

    private boolean isCancel;

    private String result;
}
