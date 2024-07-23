package com.ikhyeons.tp.time_picker_server.response.entity;

import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import com.ikhyeons.tp.time_picker_server.rDate.entity.RDate;
import com.ikhyeons.tp.time_picker_server.rDay.entity.RDay;
import com.ikhyeons.tp.time_picker_server.request.entity.Request;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@ToString
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long responseId;

    @ManyToOne
    @JoinColumn(name ="member_id")
    private Member member;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToOne
    @JoinColumn(name ="r_date_id")
    private RDate rDate;

    @ManyToOne
    @JoinColumn(name ="r_day_id")
    private RDay rDay;

    @Column(nullable = false)
    private String responseData;

    public static Response createDayResponse(Member member, RDay rDay){
        return Response.builder().member(member).type(Type.Day).rDay(rDay).responseData("{time : 1830}").build();
    }

    public static Response createDateResponse(Member member, RDate rDate){
        return Response.builder().member(member).type(Type.Date).rDate(rDate).responseData("{time : 1830}").build();
    }

    @Builder
    public Response(Member member, Type type, RDate rDate, RDay rDay, String responseData) {
        this.member = member;
        this.type = type;
        this.rDate = rDate;
        this.rDay = rDay;
        this.responseData = responseData;
    }
}
