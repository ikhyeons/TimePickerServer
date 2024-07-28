package com.ikhyeons.tp.time_picker_server.schedule.scheduleDTO;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import com.ikhyeons.tp.time_picker_server.schedule.entity.Day;
import com.ikhyeons.tp.time_picker_server.schedule.entity.Type;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class ScheduleDTO {
    private Long scheduleId;
    private Long memberId;
    private String title;
    private String description;
    private Type type;
    private String date;
    private Day day;
}
