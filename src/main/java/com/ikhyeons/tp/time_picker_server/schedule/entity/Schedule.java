package com.ikhyeons.tp.time_picker_server.schedule.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import com.ikhyeons.tp.time_picker_server.schedule.scheduleDTO.ScheduleDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Entity
@ToString
@NoArgsConstructor
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long scheduleId;

    @ManyToOne
    @JoinColumn(name ="member_id")
    private Member member;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(nullable = true)
    private String date;

    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private Day day;

    public static Schedule createScheduleChejo(Member member){
        return Schedule.builder().member(member).title("국군 도수 체조").description("이거는 진짜 인듯;").type(Type.DAY).day(Day.월).build();
    }

    @Builder
    public Schedule(Member member, String title, String description, Type type, String date, Day day) {
        this.member = member;
        this.title = title;
        this.description = description;
        this.type = type;
        this.date = date;
        this.day = day;
    }

    public ScheduleDTO toDTO(){
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setScheduleId(this.scheduleId);
        scheduleDTO.setDate(this.date);
        scheduleDTO.setDay(this.day);
        scheduleDTO.setTitle(this.title);
        scheduleDTO.setDescription(this.description);
        scheduleDTO.setMemberId(this.member.getMemberId());
        scheduleDTO.setType(this.type);
        return scheduleDTO;
    }
}
