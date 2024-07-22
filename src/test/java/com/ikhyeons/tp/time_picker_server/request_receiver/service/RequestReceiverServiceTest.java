package com.ikhyeons.tp.time_picker_server.request_receiver.service;

import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import com.ikhyeons.tp.time_picker_server.member.entity.Role;
import com.ikhyeons.tp.time_picker_server.member.service.MemberService;
import com.ikhyeons.tp.time_picker_server.request.entity.Request;
import com.ikhyeons.tp.time_picker_server.request.repository.RequestRepository;
import com.ikhyeons.tp.time_picker_server.request.service.RequestService;
import com.ikhyeons.tp.time_picker_server.request_receiver.entity.RequestReceiver;
import com.ikhyeons.tp.time_picker_server.request_receiver.repository.RequestReceiverRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@DisplayName("요청 수령자 테스트")
class RequestReceiverServiceTest {
    @Autowired
    private RequestReceiverService requestReceiverService;
    @Autowired
    private RequestReceiverRepository requestReceiverRepository;
    @Autowired
    private RequestService requestService;
    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private MemberService memberService;

    @Test
    @DisplayName("요청 수령자 추가")
    void 요청수령자추가() throws Exception {
        //given
        Member ikhyeon = Member.createMemberIkhyeon();
        Member savedMember = memberService.join(ikhyeon);

        Request request = Request.makeRequest(savedMember);
        Request savedRequest = requestService.createRequest(request);

        RequestReceiver requestReceiver = RequestReceiver.builder().member(savedMember).request(savedRequest).build();
        //when
        RequestReceiver savedRequestReceiver = requestReceiverService.addRequestReceiver(requestReceiver);
        //then
        assertThat(requestReceiverRepository.findById(savedRequestReceiver.getRequestReceiverId()).isPresent()).isTrue();
        assertThat(requestRepository.findById(savedRequestReceiver.getRequest().getRequestId()).get().getReceiverList().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("요청 수령자 삭제")
    void 요청수령자삭제() throws Exception {
        //given
        Member ikhyeon = Member.createMemberIkhyeon();
        Member suhyeon = Member.builder().mid("su2").role(Role.USER).password("supass").name("박수현").build();
        Member savedIkhyeon = memberService.join(ikhyeon);
        Member savedSuhyeon = memberService.join(suhyeon);

        Request request = Request.makeRequest(savedIkhyeon);
        Request savedRequest = requestService.createRequest(request);

        RequestReceiver requestReceiverIkhyeon= RequestReceiver.builder().member(savedIkhyeon).request(savedRequest).build();
        RequestReceiver requestReceiverSuhyeon= RequestReceiver.builder().member(savedIkhyeon).request(savedRequest).build();
        RequestReceiver savedRequestReceiverIkhyeon = requestReceiverService.addRequestReceiver(requestReceiverIkhyeon);
        RequestReceiver savedRequestReceiverSuhyeon = requestReceiverService.addRequestReceiver(requestReceiverSuhyeon);
        //when
        requestReceiverService.deleteRequestReceiver(requestReceiverIkhyeon);
        //then
        assertThat(requestReceiverRepository.findById(savedRequestReceiverSuhyeon.getRequestReceiverId()).isPresent()).isTrue();
        assertThat(requestReceiverRepository.findById(savedRequestReceiverIkhyeon.getRequestReceiverId()).isPresent()).isFalse();
        assertThat(requestRepository.findById(requestReceiverSuhyeon.getRequest().getRequestId()).get().getReceiverList().size()).isEqualTo(1);
    }
}