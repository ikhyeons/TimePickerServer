package com.ikhyeons.tp.time_picker_server.request.service;

import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import com.ikhyeons.tp.time_picker_server.request.entity.Request;
import com.ikhyeons.tp.time_picker_server.request.repository.RequestRepository;
import com.ikhyeons.tp.time_picker_server.request.requestDTO.RequestDTO;
import com.ikhyeons.tp.time_picker_server.team.entity.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RequestService {
    private final RequestRepository requestRepository;

    @Transactional
    public List<RequestDTO> getSendRequestList(Member member){
        List<Request> requestList = requestRepository.findAllByMember(member);
        List<RequestDTO> requestDTO = requestList.stream().map(data->data.toDTO()).collect(Collectors.toList());
        return requestDTO;
    }
    @Transactional
    public Request createRequest(Request request){
        return requestRepository.save(request);
    }

    @Transactional
    public Request cancelRequest(Request request){
        request.cancelRequest();
        return requestRepository.save(request);
    }

}
