package com.ikhyeons.tp.time_picker_server.friend.controller;

import com.ikhyeons.tp.time_picker_server.rDay.entity.RDay;
import com.ikhyeons.tp.time_picker_server.rDay.rDayDTO.RDayDTO;
import com.ikhyeons.tp.time_picker_server.rDay.repository.RDayRepository;
import com.ikhyeons.tp.time_picker_server.rDay.service.RDayService;
import com.ikhyeons.tp.time_picker_server.request.entity.Request;
import com.ikhyeons.tp.time_picker_server.request.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class FriendController {
    private final RDayService rDayService;
    private final RDayRepository rDayRepository;
    private final RequestRepository requestRepository;

    @PostMapping("/friend")
    public Long createRDay(@RequestBody RDayDTO postData){
        Request request = requestRepository.findById(postData.getRequest().getRequestId()).get();
        RDay rDay = RDay.builder().request(request).day(postData.getDay()).build();
        RDay savedRDay = rDayService.addRDay(rDay);
        return savedRDay.getRDayId();
    }

    @DeleteMapping("/friend")
    public boolean deleteRDay(@RequestParam Long rDayId){
        RDay rDay = rDayRepository.findById(rDayId).get();
        boolean isDelete = rDayService.removeRDay(rDay);
        return isDelete;
    }
}
