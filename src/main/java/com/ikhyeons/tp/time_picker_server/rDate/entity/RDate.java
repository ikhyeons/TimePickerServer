package com.ikhyeons.tp.time_picker_server.rDate.entity;

import com.ikhyeons.tp.time_picker_server.request.entity.Request;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@ToString
public class RDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long rDateId;

    @ManyToOne
    @JoinColumn(name = "request_id")
    private Request request;

    @Column(nullable = false)
    private String date;

    @Builder
    public RDate(Request request, String date) {
        this.request = request;
        this.date = date;
    }
}
