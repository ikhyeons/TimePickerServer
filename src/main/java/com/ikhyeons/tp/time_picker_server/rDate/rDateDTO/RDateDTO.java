package com.ikhyeons.tp.time_picker_server.rDate.rDateDTO;


import com.ikhyeons.tp.time_picker_server.request.entity.Request;

import com.ikhyeons.tp.time_picker_server.response.responseDTO.ResponseDTO;
import lombok.Data;

import java.util.List;


@Data
public class RDateDTO {
    private Long rDateId;

    private Request request;

    private String date;

    private List<ResponseDTO> responseList;
}
