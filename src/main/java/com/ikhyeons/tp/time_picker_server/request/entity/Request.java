package com.ikhyeons.tp.time_picker_server.request.entity;

import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import com.ikhyeons.tp.time_picker_server.member.entity.Role;
import com.ikhyeons.tp.time_picker_server.member.entity.SocialType;
import com.ikhyeons.tp.time_picker_server.rDate.entity.RDate;
import com.ikhyeons.tp.time_picker_server.rDay.entity.RDay;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Entity
@ToString
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long requestId;

    @ManyToOne
    @JoinColumn(name ="member_id")
    private Member member;

    @Column(nullable = false)
    private Type type;

    @Column(nullable = false)
    private String result;

    @OneToMany(mappedBy = "request")
    private List<RDay> dayList;

    @OneToMany(mappedBy = "request")
    private List<RDate> dateList;


    @Builder
    public Request(Member member, Type type, String result, List<RDay> dayList, List<RDate> dateList) {
        this.member = member;
        this.type = type;
        this.result = result;
        this.dayList = dayList;
        this.dateList = dateList;
    }
}
