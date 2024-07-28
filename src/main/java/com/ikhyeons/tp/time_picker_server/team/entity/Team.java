package com.ikhyeons.tp.time_picker_server.team.entity;

import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import com.ikhyeons.tp.time_picker_server.schedule.entity.Schedule;
import com.ikhyeons.tp.time_picker_server.team.teamDTO.TeamDTO;
import com.ikhyeons.tp.time_picker_server.teamMember.entity.TeamMember;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@ToString
@NoArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long teamId;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(nullable = false)
    private String name;


    public static Team createTeamYM(){
        return Team.builder().name("용마고").build();
    }
    @Builder
    public Team(Member member, String name) {
        this.member = member;
        this.name = name;
    }

    public TeamDTO toDTO(){
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setTeamId(this.teamId);
        teamDTO.setMemberId(this.getMember().getMemberId());
        teamDTO.setName(this.name);
        return teamDTO;
    }
}
