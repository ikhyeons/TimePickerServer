package com.ikhyeons.tp.time_picker_server.rDay.service;


import com.ikhyeons.tp.time_picker_server.rDay.entity.RDay;
import com.ikhyeons.tp.time_picker_server.rDay.repository.RDayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RDayService {
    private final RDayRepository rDayRepository;

    @Transactional
    public RDay addRDay(RDay rDay){
        rDay.getRequest().addRDay(rDay);
        return rDayRepository.save(rDay);
    }

    @Transactional
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
