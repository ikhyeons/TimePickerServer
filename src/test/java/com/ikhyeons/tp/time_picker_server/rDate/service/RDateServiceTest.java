package com.ikhyeons.tp.time_picker_server.rDate.service;

import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import com.ikhyeons.tp.time_picker_server.rDate.entity.RDate;
import com.ikhyeons.tp.time_picker_server.rDate.repository.RDateRepository;
import com.ikhyeons.tp.time_picker_server.rDay.entity.Day;
import com.ikhyeons.tp.time_picker_server.rDay.entity.RDay;
import com.ikhyeons.tp.time_picker_server.rDay.repository.RDayRepository;
import com.ikhyeons.tp.time_picker_server.rDay.service.RDayService;
import com.ikhyeons.tp.time_picker_server.request.entity.Request;
import com.ikhyeons.tp.time_picker_server.request.repository.RequestRepository;
import com.ikhyeons.tp.time_picker_server.request.service.RequestService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@DisplayName("요청 날짜 테스트")
class RDateServiceTest {
    @Autowired
    private RDateService rDateService;
    @Autowired
    private RDateRepository rDateRepository;
    @Autowired
    private RequestService requestService;
    @Autowired
    private RequestRepository requestRepository;

    @Test
    @DisplayName("요청 날짜 생성")
    void 요청날짜생성() throws Exception{
        //given
        Member ikhyeon = Member.createMemberIkhyeon();
        Request request = Request.makeDateRequest(ikhyeon);
        RDate rDate = RDate.rDate240711(request);
        //when
        RDate savedRDate = rDateService.addRDate(rDate);
        //then
        assertThat(rDateRepository.findById(savedRDate.getRDateId()).isPresent()).isTrue();
        assertThat(request.getDateList().size()).isEqualTo(1);

    }

    @Test
    @DisplayName("요청 날짜 삭제")
    void 요청날짜삭제() throws Exception{
        //given
        Member ikhyeon = Member.createMemberIkhyeon();
        Request request = Request.makeDateRequest(ikhyeon);
        RDate rDate240711 = RDate.rDate240711(request);
        RDate rDateT240713 = RDate.builder().date("2024-07-13").request(request).build();
        RDate savedRDate240711 = rDateService.addRDate(rDate240711);
        RDate savedRDate240713 = rDateService.addRDate(rDateT240713);
        //when
        rDateService.removeRDate(savedRDate240711);
        //then
        assertThat(rDateRepository.findById(savedRDate240713.getRDateId()).isPresent()).isTrue();
        assertThat(rDateRepository.findById(savedRDate240711.getRDateId()).isPresent()).isFalse();
        assertThat(savedRDate240713.getRequest().getDateList().size()).isEqualTo(1);
    }

}