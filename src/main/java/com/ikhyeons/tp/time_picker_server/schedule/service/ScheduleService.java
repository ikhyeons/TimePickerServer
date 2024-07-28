package com.ikhyeons.tp.time_picker_server.schedule.service;

import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import com.ikhyeons.tp.time_picker_server.member.repository.MemberRepository;
import com.ikhyeons.tp.time_picker_server.schedule.entity.Schedule;
import com.ikhyeons.tp.time_picker_server.schedule.repository.ScheduleRepository;
import com.ikhyeons.tp.time_picker_server.schedule.scheduleDTO.ScheduleDTO;
import com.ikhyeons.tp.time_picker_server.team.entity.Team;
import com.ikhyeons.tp.time_picker_server.team.teamDTO.TeamDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final MemberRepository memberRepository;

    public List<ScheduleDTO> getScheduleList(Long memberId){
        Member member = memberRepository.findById(memberId).get();
        List<Schedule> scheduleList = scheduleRepository.findAllByMember(member);
        List<ScheduleDTO> result = scheduleList.stream().map(data->data.toDTO()).collect(Collectors.toList());
        return result;
    }


    public Schedule saveSchedule(Schedule schedule){
        return scheduleRepository.save(schedule);
    }

    public boolean deleteSchedule(Schedule schedule){
        try{
            scheduleRepository.delete((schedule));
            schedule.getMember().deleteSchedule(schedule);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
