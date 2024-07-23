package com.ikhyeons.tp.time_picker_server.rDay.service;

import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import com.ikhyeons.tp.time_picker_server.rDay.entity.Day;
import com.ikhyeons.tp.time_picker_server.rDay.entity.RDay;
import com.ikhyeons.tp.time_picker_server.rDay.repository.RDayRepository;
import com.ikhyeons.tp.time_picker_server.request.entity.Request;
import com.ikhyeons.tp.time_picker_server.request.repository.RequestRepository;
import com.ikhyeons.tp.time_picker_server.request.service.RequestService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Transactional
@DisplayName("요청 요일 테스트")
class RDayServiceTest {
    @Autowired
    private RDayService rDayService;
    @Autowired
    private RDayRepository rDayRepository;
    @Autowired
    private RequestService requestService;
    @Autowired
    private RequestRepository requestRepository;
    @Test
    @DisplayName("요청 요일 생성")
    void 요청요일생성() throws Exception{
        //given
        Member ikhyeon = Member.createMemberIkhyeon();
        Request request = Request.makeDayRequest(ikhyeon);
        RDay rDay = RDay.RDayW(request);
        //when
        RDay savedRDay = rDayService.addRDay(rDay);
        //then
        assertThat(rDayRepository.findById(savedRDay.getRDayId()).isPresent()).isTrue();
        assertThat(request.getDayList().size()).isEqualTo(1);

    }

    @Test
    @DisplayName("요청 요일 삭제")
    void 요청요일삭제() throws Exception{
        //given
        Member ikhyeon = Member.createMemberIkhyeon();
        Request request = Request.makeDayRequest(ikhyeon);
        RDay rDayW = RDay.RDayW(request);
        RDay rDayT = RDay.builder().day(Day.목).request(request).build();
        RDay savedRDayW = rDayService.addRDay(rDayW);
        RDay savedRDayT = rDayService.addRDay(rDayT);
        //when
        rDayService.removeRDay(savedRDayW);
        //then
        assertThat(rDayRepository.findById(savedRDayT.getRDayId()).isPresent()).isTrue();
        assertThat(rDayRepository.findById(savedRDayW.getRDayId()).isPresent()).isFalse();
        assertThat(request.getDayList().size()).isEqualTo(1);
    }

}