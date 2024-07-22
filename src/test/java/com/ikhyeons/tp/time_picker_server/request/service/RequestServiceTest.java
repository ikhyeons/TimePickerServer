package com.ikhyeons.tp.time_picker_server.request.service;

import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import com.ikhyeons.tp.time_picker_server.request.entity.Request;
import com.ikhyeons.tp.time_picker_server.request.repository.RequestRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Transactional
@DisplayName("요청 테스트")
class RequestServiceTest {
    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private RequestService requestService;

    @Test
    @DisplayName("요청 생성")
    void 요청생성() throws Exception{
       //given
        Member ikhyeon = Member.createMemberIkhyeon();
        Request request = Request.makeRequest(ikhyeon);
       //when
        Request savedRequest = requestService.createRequest(request);
       //then
        assertThat(requestRepository.findById(savedRequest.getRequestId()).isPresent()).isTrue();
    }
    @Test
    @DisplayName("요청 삭제")
    void 요청취소() throws Exception{
        //given
        Member ikhyeon = Member.createMemberIkhyeon();
        Request request = Request.makeRequest(ikhyeon);
        //when
        Request cancelRequest = requestService.cancelRequest(request);
        //then
        assertThat(requestRepository.findById(cancelRequest.getRequestId()).get().isCancel()).isTrue();
    }
}