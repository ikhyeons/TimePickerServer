package com.ikhyeons.tp.time_picker_server.response.service;

import com.ikhyeons.tp.time_picker_server.rDate.entity.RDate;
import com.ikhyeons.tp.time_picker_server.rDate.repository.RDateRepository;
import com.ikhyeons.tp.time_picker_server.rDay.entity.RDay;
import com.ikhyeons.tp.time_picker_server.rDay.repository.RDayRepository;
import com.ikhyeons.tp.time_picker_server.response.entity.Response;
import com.ikhyeons.tp.time_picker_server.response.entity.Type;
import com.ikhyeons.tp.time_picker_server.response.repository.ResponseRepository;
import com.ikhyeons.tp.time_picker_server.response.responseDTO.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ResponseService {
    private final ResponseRepository responseRepository;
    private final RDateRepository rDateRepository;
    private final RDayRepository rDayRepository;


    @Transactional
    public List<ResponseDTO> getResponseList(Type type, Long id){
        List<Response> responseList;
        if(type == Type.Day){
            responseList = responseRepository.findAllByType(type).stream().filter(data->data.getRDay().getRDayId() == id).collect(Collectors.toList());
        } else {
            responseList = responseRepository.findAllByType(type).stream().filter(data->data.getRDate().getRDateId() == id).collect(Collectors.toList());
        }

        List<ResponseDTO> responseDTOList = responseList.stream().map(data->data.toDTO()).collect(Collectors.toList());
        return responseDTOList;
    }

    @Transactional
    public Response addDayResponse(Response response){
        return responseRepository.save(response);
    }

    @Transactional
    public boolean removeDayResponse(Response response){
        try{
            responseRepository.delete(response);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Transactional
    public Response addDateResponse(Response response){
        return responseRepository.save(response);
    }

    @Transactional
    public boolean removeDateResponse(Response response){
        try{
            responseRepository.delete(response);
            return true;
        } catch (Exception e){
            return false;
        }
    }

}
