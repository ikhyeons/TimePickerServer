package com.ikhyeons.tp.time_picker_server.rDate.controller;

import com.ikhyeons.tp.time_picker_server.rDate.entity.RDate;
import com.ikhyeons.tp.time_picker_server.rDate.rDateDTO.RDateDTO;
import com.ikhyeons.tp.time_picker_server.rDate.repository.RDateRepository;
import com.ikhyeons.tp.time_picker_server.rDate.service.RDateService;
import com.ikhyeons.tp.time_picker_server.request.entity.Request;
import com.ikhyeons.tp.time_picker_server.request.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RDateController {
    private final RDateService rDateService;
    private final RDateRepository rDateRepository;
    private final RequestRepository requestRepository;

    @PostMapping("/rDate")
    public Long createRDate(@RequestBody RDateDTO postData){
        Request request = requestRepository.findById(postData.getRequestId()).get();
        RDate rDate = RDate.builder().request(request).date(postData.getDate()).build();
        RDate savedRDate = rDateService.addRDate(rDate);
        return savedRDate.getRDateId();
    }

    @DeleteMapping("/rDate")
    public boolean deleteRDate(@RequestParam Long rDateId){
        RDate rDate = rDateRepository.findById(rDateId).get();
        boolean isDelete = rDateService.removeRDate(rDate);
        return isDelete;
    }
}
