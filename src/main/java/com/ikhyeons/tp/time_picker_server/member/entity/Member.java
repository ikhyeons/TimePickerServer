package com.ikhyeons.tp.time_picker_server.member.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@ToString
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Builder
    public Member() {
        //this.name = name;
    }
}
