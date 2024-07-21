package com.ikhyeons.tp.time_picker_server.team.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@ToString
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long groupId;

    @Column(nullable = false)
    private String name;

    @Builder
    public Team(String name) {
        this.name = name;
    }
}
