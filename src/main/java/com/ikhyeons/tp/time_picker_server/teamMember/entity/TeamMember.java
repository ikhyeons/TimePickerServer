package com.ikhyeons.tp.time_picker_server.teamMember.entity;

import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import com.ikhyeons.tp.time_picker_server.team.entity.Team;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@ToString
public class TeamMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long teamMemberId;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public TeamMember(Team team, Member member) {
        this.team = team;
        this.member = member;
    }
}
