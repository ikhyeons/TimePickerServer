package com.ikhyeons.tp.time_picker_server.response.responseDTO;


import com.ikhyeons.tp.time_picker_server.response.entity.Type;
import lombok.Data;

@Data
public class ResponseDTO {
    private Long responseId;
    private Long memberId;
    private Type type;
    private Long rDateId;
    private Long rDayId;
    private String responseData;
}
