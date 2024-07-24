package com.ikhyeons.tp.time_picker_server.schedule.controller;

import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import com.ikhyeons.tp.time_picker_server.member.repository.MemberRepository;
import com.ikhyeons.tp.time_picker_server.schedule.entity.Schedule;
import com.ikhyeons.tp.time_picker_server.schedule.entity.Type;
import com.ikhyeons.tp.time_picker_server.schedule.repository.ScheduleRepository;
import com.ikhyeons.tp.time_picker_server.schedule.scheduleDTO.ScheduleDTO;
import com.ikhyeons.tp.time_picker_server.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;
    private final ScheduleRepository scheduleRepository;
    private final MemberRepository memberRepository;

    @PostMapping("/schedule")
    public Long createSchedule(@RequestBody ScheduleDTO postData){
        Member member = memberRepository.findById(postData.getMemberId()).get();

        Schedule schedule;
        if(postData.getType() == Type.DATE)
            schedule = Schedule.builder().member(member).type(Type.DATE).date(postData.getDate()).title(postData.getTitle()).description(postData.getDescription()).build();
        else
            schedule = Schedule.builder().member(member).type(Type.DAY).day(postData.getDay()).title(postData.getTitle()).description(postData.getDescription()).build();

        Schedule savedSchedule = scheduleService.saveSchedule(schedule);
        return savedSchedule.getScheduleId();
    }

    @DeleteMapping("/schedule")
    public boolean deleteSchedule(@RequestParam Long scheduleId){
        Schedule schedule = scheduleRepository.findById(scheduleId).get();

        return scheduleService.deleteSchedule(schedule);
    }


}
