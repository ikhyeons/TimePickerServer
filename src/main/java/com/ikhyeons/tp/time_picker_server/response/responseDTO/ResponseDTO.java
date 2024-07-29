package com.ikhyeons.tp.time_picker_server.response.responseDTO;


import com.ikhyeons.tp.time_picker_server.response.entity.Type;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class ResponseDTO {
    private Long responseId;
    private Long memberId;
    private Type type;
    private Long responseDateId;
    private Long responseDayId;
    private String responseData;
}
