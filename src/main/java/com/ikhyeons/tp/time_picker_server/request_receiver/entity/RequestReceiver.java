package com.ikhyeons.tp.time_picker_server.request_receiver.entity;

import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import com.ikhyeons.tp.time_picker_server.request.entity.Request;
import com.ikhyeons.tp.time_picker_server.request.entity.Type;
import com.ikhyeons.tp.time_picker_server.request_receiver.receiverDTO.ReceiverDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Getter
@Entity
@ToString
@NoArgsConstructor
public class RequestReceiver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long requestReceiverId;

    @ManyToOne
    @JoinColumn(name ="request_id")
    private Request request;

    @ManyToOne
    @JoinColumn(name ="member_id")
    private Member member;


    public ReceiverDTO toDTO(){
        ReceiverDTO receiverDTO = new ReceiverDTO();

        receiverDTO.setRequestReceiverId(this.requestReceiverId);
        receiverDTO.setRequestId(this.request.getRequestId());
        receiverDTO.setMemberId(this.member.getMemberId());

        return receiverDTO;
    }
    @Builder
    public RequestReceiver(Request request, Member member) {
        this.request = request;
        this.member = member;
    }
}
