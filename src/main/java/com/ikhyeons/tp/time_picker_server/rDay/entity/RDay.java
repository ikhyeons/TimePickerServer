package com.ikhyeons.tp.time_picker_server.rDay.entity;

import com.ikhyeons.tp.time_picker_server.request.entity.Request;
import com.ikhyeons.tp.time_picker_server.request.entity.Type;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@ToString
public class RDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long rDayId;


    @ManyToOne
    @JoinColumn(name = "request_id")
    private Request request;

    @Column(nullable = false)
    private Day day;



    @Builder

    public RDay(Request request, Day day) {
        this.request = request;
        this.day = day;
    }
}
