package com.ikhyeons.tp.time_picker_server.rDate.rDateDTO;


import com.ikhyeons.tp.time_picker_server.request.entity.Request;

import lombok.Data;


@Data
public class RDateDTO {
    private Long rDateId;
    private Long requestId;
    private String date;
}
