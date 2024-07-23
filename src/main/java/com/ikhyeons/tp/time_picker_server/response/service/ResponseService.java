package com.ikhyeons.tp.time_picker_server.response.service;

import com.ikhyeons.tp.time_picker_server.response.entity.Response;
import com.ikhyeons.tp.time_picker_server.response.repository.ResponseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResponseService {
    private final ResponseRepository responseRepository;

    public Response addDayResponse(Response response){
        response.getRDay().addResponse(response);
        return responseRepository.save(response);
    }

    public boolean removeDayResponse(Response response){
        try{
            responseRepository.delete(response);
            response.getRDay().deleteResponse(response);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public Response addDateResponse(Response response){
        response.getRDate().addResponse(response);
        return responseRepository.save(response);
    }

    public boolean removeDateResponse(Response response){
        try{
            responseRepository.delete(response);
            response.getRDate().deleteResponse(response);
            return true;
        } catch (Exception e){
            return false;
        }
    }

}
