package com.ikhyeons.tp.time_picker_server.member.memberDTO;

import com.ikhyeons.tp.time_picker_server.member.entity.Role;
import com.ikhyeons.tp.time_picker_server.member.entity.SocialType;
import com.ikhyeons.tp.time_picker_server.request.entity.Request;
import com.ikhyeons.tp.time_picker_server.response.entity.Response;
import com.ikhyeons.tp.time_picker_server.schedule.entity.Schedule;
import com.ikhyeons.tp.time_picker_server.team.entity.Team;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MemberDTO {
    private Long memberId;
    private String mid;
    private String password;
    private String name;
    private String role;
    private List<Request> requestList = new ArrayList<>();
    private List<Schedule> scheduleList = new ArrayList<>();
    private List<Team> TeamList = new ArrayList<>();
    private List<Response> ResponseList = new ArrayList<>();
    //social login
    private SocialType socialType;
    private String socialId;
}
