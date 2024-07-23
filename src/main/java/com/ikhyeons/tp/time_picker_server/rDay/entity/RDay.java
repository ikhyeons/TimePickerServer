package com.ikhyeons.tp.time_picker_server.rDay.entity;

import com.ikhyeons.tp.time_picker_server.request.entity.Request;
import com.ikhyeons.tp.time_picker_server.request.entity.Type;
import com.ikhyeons.tp.time_picker_server.response.entity.Response;
import com.ikhyeons.tp.time_picker_server.schedule.entity.Schedule;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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
    @Enumerated(EnumType.STRING)
    private Day day;

    @OneToMany(mappedBy = "rDay")
    private List<Response> responseList = new ArrayList<>();

    public void addResponse(Response response){
        this.responseList.add(response);
    }
    public void deleteResponse(Response response){
        this.responseList.remove(response);
    }

    public static RDay RDayW(Request request){
        return RDay.builder().request(request).day(Day.수).build();
    }



    @Builder
    public RDay(Request request, Day day) {
        this.request = request;
        this.day = day;
    }
}
