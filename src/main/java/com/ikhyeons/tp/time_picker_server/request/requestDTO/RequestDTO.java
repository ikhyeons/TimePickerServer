package com.ikhyeons.tp.time_picker_server.request.requestDTO;

import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import com.ikhyeons.tp.time_picker_server.rDate.entity.RDate;
import com.ikhyeons.tp.time_picker_server.rDay.entity.RDay;
import com.ikhyeons.tp.time_picker_server.request.entity.Type;
import com.ikhyeons.tp.time_picker_server.request_receiver.entity.RequestReceiver;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;

@Data
public class RequestDTO {
    private Long requestId;
    private Long memberId;
    private Type type;
    private String title;
    private String description;
    private String deadline;

    private String result;
}
