package com.ikhyeons.tp.time_picker_server.response.controller;

import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import com.ikhyeons.tp.time_picker_server.member.repository.MemberRepository;
import com.ikhyeons.tp.time_picker_server.rDate.entity.RDate;
import com.ikhyeons.tp.time_picker_server.rDate.repository.RDateRepository;
import com.ikhyeons.tp.time_picker_server.rDay.entity.RDay;
import com.ikhyeons.tp.time_picker_server.rDay.repository.RDayRepository;
import com.ikhyeons.tp.time_picker_server.response.entity.Response;
import com.ikhyeons.tp.time_picker_server.response.entity.Type;
import com.ikhyeons.tp.time_picker_server.response.repository.ResponseRepository;
import com.ikhyeons.tp.time_picker_server.response.responseDTO.ResponseDTO;
import com.ikhyeons.tp.time_picker_server.response.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ResponseController {
    private final ResponseService responseService;
    private final ResponseRepository responseRepository;
    private final MemberRepository memberRepository;
    private final RDayRepository rDayRepository;
    private final RDateRepository rDateRepository;

    @PostMapping("/response")
    public Long createResponse(@RequestBody ResponseDTO postData){
        Member member = memberRepository.findById(postData.getMemberId()).get();
        Response response;
        Long responseId;

        if(postData.getType() == Type.Day){
            RDay rDay = rDayRepository.findById(postData.getRDayId()).get();
            response = Response.builder().member(member).type(Type.Day).rDay(rDay).responseData(postData.getResponseData()).build();
            responseId = responseService.addDayResponse(response).getResponseId();
        } else {
            RDate rDate = rDateRepository.findById(postData.getRDateId()).get();
            response = Response.builder().member(member).type(Type.Date).rDate(rDate).responseData(postData.getResponseData()).build();
            responseId = responseService.addDateResponse(response).getResponseId();
        }
        return responseId;
    }

    @DeleteMapping("/response")
    public boolean deleteResponse(@RequestParam Long responseId){
        Response response = responseRepository.findById(responseId).get();

        boolean isDelete;
        if(response.getType() == Type.Day) isDelete = responseService.removeDayResponse(response);
        else isDelete = responseService.removeDateResponse(response);

        return isDelete;
    }
}
