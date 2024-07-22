package com.ikhyeons.tp.time_picker_server.schedule.service;

import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import com.ikhyeons.tp.time_picker_server.member.entity.Role;
import com.ikhyeons.tp.time_picker_server.member.service.MemberService;
import com.ikhyeons.tp.time_picker_server.schedule.entity.Day;
import com.ikhyeons.tp.time_picker_server.schedule.entity.Schedule;
import com.ikhyeons.tp.time_picker_server.schedule.entity.Type;
import com.ikhyeons.tp.time_picker_server.schedule.repository.ScheduleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@DisplayName("스케쥴 테스트")
class ScheduleServiceTest {
    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private  ScheduleRepository scheduleRepository;
    @Autowired
    private MemberService memberService;

    @Test
    @DisplayName("스케쥴 생성")
    void 스케쥴생성() throws Exception{
        //given
        Member member = Member.createMemberIkhyeon();
        Member joinedMember = memberService.join(member);
        Schedule schedule = Schedule.createScheduleChejo(joinedMember);
        //when
        Schedule savedSchedule = scheduleService.saveSchedule(schedule);
        //then
        assertThat(scheduleRepository.findById(savedSchedule.getScheduleId()).isPresent()).isTrue();
    }

    @Test
    @DisplayName("스케쥴 삭제")
    void 스케쥴삭제() throws Exception{
        //given
        Member member = Member.createMemberIkhyeon();
        Member joinedMember = memberService.join(member);
        Schedule schedule = Schedule.createScheduleChejo(joinedMember);
        Schedule savedSchedule = scheduleService.saveSchedule(schedule);
        //when
        scheduleService.deleteSchedule(schedule);
        //then
        assertThat(scheduleRepository.findById(savedSchedule.getScheduleId()).isPresent()).isFalse();

    }
}