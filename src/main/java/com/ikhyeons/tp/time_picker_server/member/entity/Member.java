package com.ikhyeons.tp.time_picker_server.member.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ikhyeons.tp.time_picker_server.request.entity.Request;
import com.ikhyeons.tp.time_picker_server.response.entity.Response;
import com.ikhyeons.tp.time_picker_server.schedule.entity.Schedule;
import com.ikhyeons.tp.time_picker_server.team.entity.Team;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@ToString
@NoArgsConstructor
@JsonIgnoreProperties({"password", "requestList", "scheduleList", "teamList", "responseList"})
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long memberId;

    @Column(unique = true, nullable = false)
    private String mid;

    @JsonIgnoreProperties
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String role;


    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
    private List<Request> requestList = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Schedule> scheduleList = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Team> teamList = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Response> responseList = new ArrayList<>();

    //social login
    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    private String socialId;

    public void addSchedule(Schedule schedule){
        this.scheduleList.add(schedule);
    }
    public void deleteSchedule(Schedule schedule){
        this.scheduleList.remove(schedule);
    }

    @Builder
    public Member(String mid, String password, String name, String role, SocialType socialType, String socialId) {
        this.mid = mid;
        this.password = password;
        this.name = name;
        this.role = role;
        this.socialType = socialType;
        this.socialId = socialId;
    }

    public static Member createMemberIkhyeon(){
        return Member.builder().mid("skantrkwl789").name("성익현").role("USER").password("tjddlrgus33!").build();
    }
}
