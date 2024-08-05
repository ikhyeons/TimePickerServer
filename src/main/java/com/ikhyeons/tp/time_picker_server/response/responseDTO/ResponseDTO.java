package com.ikhyeons.tp.time_picker_server.response.responseDTO;


import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import com.ikhyeons.tp.time_picker_server.rDate.entity.RDate;
import com.ikhyeons.tp.time_picker_server.rDate.rDateDTO.RDateDTO;
import com.ikhyeons.tp.time_picker_server.rDay.entity.RDay;
import com.ikhyeons.tp.time_picker_server.rDay.rDayDTO.RDayDTO;
import com.ikhyeons.tp.time_picker_server.response.entity.Type;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class ResponseDTO {
    private Long responseId;

    private Member member;

    private Type type;

    private RDate responseDate;

    private RDay responseDay;

    private String responseData;

}
