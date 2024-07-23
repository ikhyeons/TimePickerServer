package com.ikhyeons.tp.time_picker_server.rDay.service;


import com.ikhyeons.tp.time_picker_server.rDay.entity.RDay;
import com.ikhyeons.tp.time_picker_server.rDay.repository.RDayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RDayService {
    private final RDayRepository rDayRepository;

    public RDay addRDay(RDay rDay){
        rDay.getRequest().addRDay(rDay);
        return rDayRepository.save(rDay);
    }

    public boolean removeRDay(RDay rDay){
        try{
            rDay.getRequest().deleteRDay(rDay);
            rDayRepository.delete(rDay);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
