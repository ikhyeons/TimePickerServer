package com.ikhyeons.tp.time_picker_server.request_receiver.service;

import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import com.ikhyeons.tp.time_picker_server.request.entity.Request;
import com.ikhyeons.tp.time_picker_server.request.requestDTO.RequestDTO;
import com.ikhyeons.tp.time_picker_server.request_receiver.entity.RequestReceiver;
import com.ikhyeons.tp.time_picker_server.request_receiver.repository.RequestReceiverRepository;
import com.ikhyeons.tp.time_picker_server.schedule.entity.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RequestReceiverService {

    private final RequestReceiverRepository requestReceiverRepository;


    @Transactional
    public List<RequestDTO> findMyReceiveRequest(Member member){
        List<RequestReceiver> requestReceiverList = requestReceiverRepository.findAllByMember(member);
        List<Request> requestList = requestReceiverList.stream().map(data->data.getRequest()).collect(Collectors.toList());
        List<RequestDTO> requestDTOList = requestList.stream().map(data->data.toDTO()).collect(Collectors.toList());
        return requestDTOList;
    }
    @Transactional
    public RequestReceiver addRequestReceiver(RequestReceiver requestReceiver){
        RequestReceiver savedRequestReceiver = requestReceiverRepository.save(requestReceiver);
        savedRequestReceiver.getRequest().addReceiver(requestReceiver);
        return savedRequestReceiver;
    }
    @Transactional
    public boolean deleteRequestReceiver(RequestReceiver requestReceiver){
        try{
            requestReceiver.getRequest().deleteReceiver(requestReceiver);
            requestReceiverRepository.delete(requestReceiver);

            return true;
        } catch (Exception e){
            return false;
        }
    }

}
