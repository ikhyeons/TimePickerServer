package com.ikhyeons.tp.time_picker_server.request_receiver.service;

import com.ikhyeons.tp.time_picker_server.request.entity.Request;
import com.ikhyeons.tp.time_picker_server.request_receiver.entity.RequestReceiver;
import com.ikhyeons.tp.time_picker_server.request_receiver.repository.RequestReceiverRepository;
import com.ikhyeons.tp.time_picker_server.schedule.entity.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequestReceiverService {

    private final RequestReceiverRepository requestReceiverRepository;

    public RequestReceiver addRequestReceiver(RequestReceiver requestReceiver){
        RequestReceiver savedRequestReceiver = requestReceiverRepository.save(requestReceiver);
        savedRequestReceiver.getRequest().addReceiver(requestReceiver);
        return savedRequestReceiver;
    }
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
