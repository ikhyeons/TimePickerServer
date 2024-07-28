package com.ikhyeons.tp.time_picker_server.schedule.controller;

import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import com.ikhyeons.tp.time_picker_server.member.repository.MemberRepository;
import com.ikhyeons.tp.time_picker_server.schedule.entity.Schedule;
import com.ikhyeons.tp.time_picker_server.schedule.entity.Type;
import com.ikhyeons.tp.time_picker_server.schedule.repository.ScheduleRepository;
import com.ikhyeons.tp.time_picker_server.schedule.scheduleDTO.ScheduleDTO;
import com.ikhyeons.tp.time_picker_server.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;
    private final ScheduleRepository scheduleRepository;
    private final MemberRepository memberRepository;


    @GetMapping("/schedule")
    public List<ScheduleDTO> getScheduleList(){
        String memberId = SecurityContextHolder.getContext().getAuthentication().getName();
        Member member = memberRepository.findOneByMid(memberId).get();

        return scheduleService.getScheduleList(member.getMemberId());
    }
    @PostMapping("/schedule")
    public Long createSchedule(@RequestBody ScheduleDTO postData){
        String memberId = SecurityContextHolder.getContext().getAuthentication().getName();
        Member member = memberRepository.findOneByMid(memberId).get();

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
