package com.ikhyeons.tp.time_picker_server.friendRequest.entity;

import com.ikhyeons.tp.time_picker_server.friend.friendDTO.FriendDTO;
import com.ikhyeons.tp.time_picker_server.friendRequest.friendRequestDTO.FriendRequestDTO;
import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Entity
@ToString
@NoArgsConstructor
public class FriendRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long friendRequestId;

    @ManyToOne
    @JoinColumn(name = "requester_id")
    private Member requester;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private Member receiver;

    public static FriendRequest createFriendRequest(Member requester, Member receiver){
        return FriendRequest.builder().requester(requester).receiver(receiver).build();
    }

    public FriendRequestDTO toDTO(){
        FriendRequestDTO friendRequestDTO = new FriendRequestDTO();
        friendRequestDTO.setRequester(this.requester);
        friendRequestDTO.setReceiver(this.receiver);

        return friendRequestDTO;
    }


    @Builder
    public FriendRequest(Member requester, Member receiver) {
        this.requester = requester;
        this.receiver = receiver;
    }
}
