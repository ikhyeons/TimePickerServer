package com.ikhyeons.tp.time_picker_server.request.controller;

import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import com.ikhyeons.tp.time_picker_server.member.repository.MemberRepository;
import com.ikhyeons.tp.time_picker_server.rDate.entity.RDate;
import com.ikhyeons.tp.time_picker_server.rDate.rDateDTO.RDateDTO;
import com.ikhyeons.tp.time_picker_server.rDate.repository.RDateRepository;
import com.ikhyeons.tp.time_picker_server.rDay.entity.Day;
import com.ikhyeons.tp.time_picker_server.rDay.entity.RDay;
import com.ikhyeons.tp.time_picker_server.rDay.rDayDTO.RDayDTO;
import com.ikhyeons.tp.time_picker_server.rDay.repository.RDayRepository;
import com.ikhyeons.tp.time_picker_server.request.entity.Request;
import com.ikhyeons.tp.time_picker_server.request.entity.Type;
import com.ikhyeons.tp.time_picker_server.request.repository.RequestRepository;
import com.ikhyeons.tp.time_picker_server.request.requestDTO.RequestDTO;
import com.ikhyeons.tp.time_picker_server.request.service.RequestService;
import com.ikhyeons.tp.time_picker_server.request_receiver.entity.RequestReceiver;
import com.ikhyeons.tp.time_picker_server.request_receiver.receiverDTO.ReceiverDTO;
import com.ikhyeons.tp.time_picker_server.request_receiver.repository.RequestReceiverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.Receiver;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class RequestController {
    private final RequestRepository requestRepository;
    private final RequestService requestService;
    private final MemberRepository memberRepository;
    private final RequestReceiverRepository requestReceiverRepository;
    private final RDayRepository rDayRepository;
    private final RDateRepository rDateRepository;

    private RDay dayDTOtoEntity(Long requestId, RDayDTO rDayDTO){
        return RDay.builder().request(requestRepository.findById(requestId).get()).day(rDayDTO.getDay()).build();
    }

    private RDate dateDTOtoEntity(Long requestId, RDateDTO rDateDTO){
        return RDate.builder().request(requestRepository.findById(requestId).get()).date(rDateDTO.getDate()).build();
    }

    private RequestReceiver receiverDTOtoReceiver(Long requestId, Long memberId){
        return RequestReceiver.builder().request(requestRepository.findById(requestId).get()).member(memberRepository.findById(memberId).get()).build();
    }

    @GetMapping("/sendRequest")
    public List<RequestDTO> getSendRequestList(){
        String memberId = SecurityContextHolder.getContext().getAuthentication().getName();
        Member member = memberRepository.findOneByMid(memberId).get();

        List<RequestDTO> requestList = requestService.getSendRequestList(member);

        return requestList;
    }


    @PostMapping("/request")
    public Long createRequest(@RequestBody RequestDTO postData){
        String memberId = SecurityContextHolder.getContext().getAuthentication().getName();
        Member member = memberRepository.findOneByMid(memberId).get();

        Request request;
        if(postData.getType() == Type.DAY){
            request = Request
                .builder()
                .member(member)
                .title(postData.getTitle())
                .description(postData.getDescription())
                .type(Type.DAY)
                .deadline(postData.getDeadline())
                .build();
        }
        else {
            request = Request
                .builder()
                .member(member)
                .title(postData.getTitle())
                .description(postData.getDescription())
                .type(Type.DATE)
                .deadline(postData.getDeadline())
                .build();
        }
        Request savedRequest = requestService.createRequest(request);

        List<Long> receiverIdList = postData.getReceiverList().stream().map(data->data.getRequestReceiverId()).collect(Collectors.toList());
        List<Member> receiverMemberList = memberRepository.findAllById(receiverIdList);
        List<RequestReceiver> receiverList = receiverMemberList.stream().map(receiverMember -> receiverDTOtoReceiver(request.getRequestId(), receiverMember.getMemberId())).collect(Collectors.toList());
        requestReceiverRepository.saveAll(receiverList);


        List<RDayDTO> dayDTOList = postData.getDayList();
        List<RDateDTO> dateDTOList = postData.getDateList();
        if(postData.getType() == Type.DAY) {
            List<RDay> dayList = dayDTOList.stream().map(dayDTO -> dayDTOtoEntity(savedRequest.getRequestId(), dayDTO)).collect(Collectors.toList());
            rDayRepository.saveAll(dayList);
        } else {
            List<RDate> dateList = dateDTOList.stream().map(dateDTO -> dateDTOtoEntity(savedRequest.getRequestId(), dateDTO)).collect(Collectors.toList());
            rDateRepository.saveAll(dateList);
        }

        return savedRequest.getRequestId();
    }

    @DeleteMapping("/request")
    public Long deleteRequest(@RequestParam("requestId") Long requestId){

        Request request = requestRepository.findById(requestId).get();
        Request savedRequest = requestService.cancelRequest(request);

        return savedRequest.getRequestId();
    }
}
