package com.ikhyeons.tp.time_picker_server.rDate.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ikhyeons.tp.time_picker_server.rDate.rDateDTO.RDateDTO;
import com.ikhyeons.tp.time_picker_server.request.entity.Request;
import com.ikhyeons.tp.time_picker_server.response.entity.Response;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Entity
@ToString
@NoArgsConstructor
@JsonIgnoreProperties({"responseList"})
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

    @OneToMany(mappedBy = "rDate")
    private List<Response> responseList = new ArrayList<>();

    public void addResponse(Response response){
        this.responseList.add(response);
    }
    public void deleteResponse(Response response){
        this.responseList.remove(response);
    }

    public static RDate rDate240711(Request request){
        return RDate.builder().request(request).date("2024-07-11").build();
    }
    public RDateDTO toDTO(){
        RDateDTO rDateDTO = new RDateDTO();
        rDateDTO.setRDateId(this.rDateId);
        rDateDTO.setDate(this.date);
        rDateDTO.setRequest(this.request);
        rDateDTO.setResponseList(this.responseList.stream().map(data->data.toDTO()).collect(Collectors.toList()));
        return rDateDTO;
    }
    @Builder
    public RDate(Request request, String date) {
        this.request = request;
        this.date = date;
    }
}
