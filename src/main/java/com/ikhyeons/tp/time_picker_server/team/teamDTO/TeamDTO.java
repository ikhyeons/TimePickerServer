package com.ikhyeons.tp.time_picker_server.team.teamDTO;

import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import com.ikhyeons.tp.time_picker_server.team.entity.Team;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
public class TeamDTO {
    private Long teamId;
    private Long memberId;
    private String name;
}
