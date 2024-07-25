package com.ikhyeons.tp.time_picker_server.request.controller;

import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import com.ikhyeons.tp.time_picker_server.member.repository.MemberRepository;
import com.ikhyeons.tp.time_picker_server.request.entity.Request;
import com.ikhyeons.tp.time_picker_server.request.entity.Type;
import com.ikhyeons.tp.time_picker_server.request.repository.RequestRepository;
import com.ikhyeons.tp.time_picker_server.request.requestDTO.RequestDTO;
import com.ikhyeons.tp.time_picker_server.request.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RequestController {
    private final RequestRepository requestRepository;
    private final RequestService requestService;
    private final MemberRepository memberRepository;

    @PostMapping("/request")
    public Long createRequest(@RequestBody RequestDTO postData){
        Member member = memberRepository.findById(postData.getMemberId()).get();
        Request request;
        if(postData.getType() == Type.DAY)
            request = Request.builder().member(member).title(postData.getTitle()).description(postData.getDescription()).type(Type.DAY).deadline(postData.getDeadline()).build();
        else
            request = Request.builder().member(member).title(postData.getTitle()).description(postData.getDescription()).type(Type.DATE).deadline(postData.getDeadline()).build();
        Request savedRequest = requestService.createRequest(request);
        return savedRequest.getRequestId();
    }

    @DeleteMapping("/request")
    public Long deleteRequest(@RequestParam Long requestId){
        Request request = requestRepository.findById(requestId).get();
        Request savedRequest = requestService.cancelRequest(request);

        return savedRequest.getRequestId();
    }
}
