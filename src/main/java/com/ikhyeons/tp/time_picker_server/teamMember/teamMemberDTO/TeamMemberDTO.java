package com.ikhyeons.tp.time_picker_server.teamMember.teamMemberDTO;

import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import com.ikhyeons.tp.time_picker_server.team.entity.Team;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class TeamMemberDTO {
    private Long teamMemberId;
    private Long teamId;
    private Long memberId;

}
