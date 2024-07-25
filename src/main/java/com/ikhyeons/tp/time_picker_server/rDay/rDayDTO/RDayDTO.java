package com.ikhyeons.tp.time_picker_server.rDay.rDayDTO;


import com.ikhyeons.tp.time_picker_server.rDay.entity.Day;
import lombok.Data;

@Data
public class RDayDTO {
    private Long rDayId;
    private Long requestId;
    private Day day;
}
