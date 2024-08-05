package com.ikhyeons.tp.time_picker_server.rDate.service;


import com.ikhyeons.tp.time_picker_server.rDate.entity.RDate;
import com.ikhyeons.tp.time_picker_server.rDate.repository.RDateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RDateService {
    private final RDateRepository rDateRepository;

    @Transactional
    public RDate addRDate(RDate rDate){
        rDate.getRequest().addRDate(rDate);
        return rDateRepository.save(rDate);
    }

    @Transactional
    public boolean removeRDate(RDate rDate){
        try{
            rDate.getRequest().deleteRDate(rDate);
            rDateRepository.delete(rDate);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
