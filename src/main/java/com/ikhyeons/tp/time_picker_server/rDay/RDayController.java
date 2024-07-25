package com.ikhyeons.tp.time_picker_server.rDay;

import com.ikhyeons.tp.time_picker_server.rDate.entity.RDate;
import com.ikhyeons.tp.time_picker_server.rDate.rDateDTO.RDateDTO;
import com.ikhyeons.tp.time_picker_server.rDay.entity.RDay;
import com.ikhyeons.tp.time_picker_server.rDay.rDayDTO.RDayDTO;
import com.ikhyeons.tp.time_picker_server.rDay.repository.RDayRepository;
import com.ikhyeons.tp.time_picker_server.rDay.service.RDayService;
import com.ikhyeons.tp.time_picker_server.request.entity.Request;
import com.ikhyeons.tp.time_picker_server.request.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RDayController {
    private final RDayService rDayService;
    private final RDayRepository rDayRepository;
    private final RequestRepository requestRepository;

    @PostMapping("/rDay")
    public Long createRDay(@RequestBody RDayDTO postData){
        Request request = requestRepository.findById(postData.getRequestId()).get();
        RDay rDay = RDay.builder().request(request).day(postData.getDay()).build();
        RDay savedRDay = rDayService.addRDay(rDay);
        return savedRDay.getRDayId();
    }

    @PostMapping("/rDay")
    public boolean deleteRDay(@RequestParam Long rDayId){
        RDay rDay = rDayRepository.findById(rDayId).get();
        boolean isDelete = rDayService.removeRDay(rDay);
        return isDelete;
    }
}
