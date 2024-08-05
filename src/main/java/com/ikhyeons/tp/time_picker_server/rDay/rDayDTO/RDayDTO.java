package com.ikhyeons.tp.time_picker_server.rDay.rDayDTO;


import com.ikhyeons.tp.time_picker_server.rDay.entity.Day;
import com.ikhyeons.tp.time_picker_server.request.entity.Request;
import com.ikhyeons.tp.time_picker_server.response.responseDTO.ResponseDTO;
import lombok.Data;

import java.util.List;

@Data
public class RDayDTO {
    private Long rDayId;

    private Request request;

    private Day day;

    private List<ResponseDTO> responseList;
}
