package com.ikhyeons.tp.time_picker_server.request_receiver.controller;

import com.ikhyeons.tp.time_picker_server.member.entity.Member;

import com.ikhyeons.tp.time_picker_server.member.repository.MemberRepository;
import com.ikhyeons.tp.time_picker_server.request.entity.Request;
import com.ikhyeons.tp.time_picker_server.request.repository.RequestRepository;
import com.ikhyeons.tp.time_picker_server.request.requestDTO.RequestDTO;
import com.ikhyeons.tp.time_picker_server.request_receiver.entity.RequestReceiver;
import com.ikhyeons.tp.time_picker_server.request_receiver.receiverDTO.ReceiverDTO;
import com.ikhyeons.tp.time_picker_server.request_receiver.repository.RequestReceiverRepository;
import com.ikhyeons.tp.time_picker_server.request_receiver.service.RequestReceiverService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.Receiver;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReceiverController {
    private final RequestReceiverService requestReceiverService;
    private final RequestReceiverRepository requestReceiverRepository;
    private final MemberRepository memberRepository;
    private final RequestRepository requestRepository;

    @GetMapping("/receiveRequest")
    public List<RequestDTO> findGetRequest(){
        String memberId = SecurityContextHolder.getContext().getAuthentication().getName();
        Member member = memberRepository.findOneByMid(memberId).get();
        return requestReceiverService.findMyReceiveRequest(member);
    }
    @PostMapping("/receiver")
    public Long addReceiver(@RequestBody ReceiverDTO postData){
        Member member = memberRepository.findById(postData.getMember().getMemberId()).get();
        Request request = requestRepository.findById(postData.getRequest().getRequestId()).get();
        RequestReceiver requestReceiver = RequestReceiver.builder().member(member).request(request).build();
        RequestReceiver savedReceiver = requestReceiverService.addRequestReceiver(requestReceiver);
        return savedReceiver.getRequestReceiverId();
    }

    @DeleteMapping("/receiver")
    public boolean removeReceiver(@RequestParam Long receiverId){
        RequestReceiver requestReceiver = requestReceiverRepository.findById(receiverId).get();
        boolean isDelete = requestReceiverService.deleteRequestReceiver(requestReceiver);

        return isDelete;
    }
}
