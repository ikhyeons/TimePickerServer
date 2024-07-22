package com.ikhyeons.tp.time_picker_server.schedule.service;

import com.ikhyeons.tp.time_picker_server.schedule.entity.Schedule;
import com.ikhyeons.tp.time_picker_server.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public Schedule saveSchedule(Schedule schedule){
        schedule.getMember().addSchedule(schedule);
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
