package com.ikhyeons.tp.time_picker_server.response.service;

import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import com.ikhyeons.tp.time_picker_server.member.repository.MemberRepository;
import com.ikhyeons.tp.time_picker_server.member.service.MemberService;
import com.ikhyeons.tp.time_picker_server.rDate.entity.RDate;
import com.ikhyeons.tp.time_picker_server.rDay.entity.RDay;
import com.ikhyeons.tp.time_picker_server.request.entity.Request;
import com.ikhyeons.tp.time_picker_server.response.entity.Response;
import com.ikhyeons.tp.time_picker_server.response.repository.ResponseRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@DisplayName("응답 테스트")
class ResponseServiceTest {
    @Autowired
    private ResponseService responseService;
    @Autowired
    private ResponseRepository responseRepository;

    @Test
    @DisplayName("요일 응답 생성")
    void 요일응답생성() throws Exception{
        //given
        Member ikhyeon = Member.createMemberIkhyeon();
        Request request = Request.makeDayRequest(ikhyeon);
        RDay rDay = RDay.RDayW(request);
        Response dayResponse = Response.createDayResponse(ikhyeon, rDay);
        //when
        Response savedDayResponse = responseService.addDayResponse(dayResponse);
        //then
        assertThat(responseRepository.findById(savedDayResponse.getResponseId()).isPresent()).isTrue();
        assertThat(dayResponse.getRDay().getResponseList().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("요일 응답 삭제")
    void 요일응답삭제() throws Exception{
        //given
        Member ikhyeon = Member.createMemberIkhyeon();
        Request request = Request.makeDayRequest(ikhyeon);
        RDay rDay1 = RDay.RDayW(request);
        RDay rDay2 = RDay.RDayW(request);
        Response dayResponse1 = Response.createDayResponse(ikhyeon, rDay1);
        Response dayResponse2 = Response.createDayResponse(ikhyeon, rDay2);
        Response savedDayResponse1 = responseService.addDayResponse(dayResponse1);
        Response savedDayResponse2 = responseService.addDayResponse(dayResponse2);
        //when
        responseService.removeDayResponse(savedDayResponse1);
        //then
        assertThat(responseRepository.findById(savedDayResponse1.getResponseId()).isPresent()).isFalse();
        assertThat(responseRepository.findById(savedDayResponse2.getResponseId()).isPresent()).isTrue();
        assertThat(savedDayResponse2.getRDay().getResponseList().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("날짜 응답 생성")
    void 날짜응답생성() throws Exception{
        //given
        Member ikhyeon = Member.createMemberIkhyeon();
        Request request = Request.makeDayRequest(ikhyeon);
        RDate rDate = RDate.rDate240711(request);
        Response dateResponse = Response.createDateResponse(ikhyeon, rDate);
        //when
        Response savedDateResponse = responseService.addDateResponse(dateResponse);
        //then
        assertThat(responseRepository.findById(savedDateResponse.getResponseId()).isPresent()).isTrue();
        assertThat(dateResponse.getRDate().getResponseList().size()).isEqualTo(1);
    }
    
    @Test
    @DisplayName("날짜 응답 삭제")
    void 날짜응답삭제() throws Exception{
        //given
        Member ikhyeon = Member.createMemberIkhyeon();
        Request request = Request.makeDayRequest(ikhyeon);
        RDate rDate1 = RDate.rDate240711(request);
        RDate rDate2 = RDate.builder().date("2024-07-13").request(request).build();
        Response dateResponse1 = Response.createDateResponse(ikhyeon, rDate1);
        Response dateResponse2 = Response.createDateResponse(ikhyeon, rDate2);
        Response savedDateResponse1 = responseService.addDateResponse(dateResponse1);
        Response savedDateResponse2 = responseService.addDateResponse(dateResponse2);
        //when
        responseService.removeDayResponse(savedDateResponse1);
        //then
        assertThat(responseRepository.findById(savedDateResponse1.getResponseId()).isPresent()).isFalse();
        assertThat(responseRepository.findById(savedDateResponse2.getResponseId()).isPresent()).isTrue();
        assertThat(savedDateResponse2.getRDate().getResponseList().size()).isEqualTo(1);
    }
}