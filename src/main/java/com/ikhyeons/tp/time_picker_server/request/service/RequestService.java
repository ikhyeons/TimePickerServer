package com.ikhyeons.tp.time_picker_server.request.service;

import com.ikhyeons.tp.time_picker_server.request.entity.Request;
import com.ikhyeons.tp.time_picker_server.request.repository.RequestRepository;
import com.ikhyeons.tp.time_picker_server.team.entity.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequestService {
    private final RequestRepository requestRepository;

    public Request createRequest(Request request){
        return requestRepository.save(request);
    }

    public Request cancelRequest(Request request){
        request.cancelRequest();
        return requestRepository.save(request);
    }

}
