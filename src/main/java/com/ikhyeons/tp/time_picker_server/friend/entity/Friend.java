package com.ikhyeons.tp.time_picker_server.friend.entity;

import com.ikhyeons.tp.time_picker_server.friend.friendDTO.FriendDTO;
import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import com.ikhyeons.tp.time_picker_server.rDay.entity.Day;
import com.ikhyeons.tp.time_picker_server.rDay.rDayDTO.RDayDTO;
import com.ikhyeons.tp.time_picker_server.request.entity.Request;
import com.ikhyeons.tp.time_picker_server.response.entity.Response;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Entity
@ToString
@NoArgsConstructor
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long friendId;

    @ManyToOne
    @JoinColumn(name = "request_id")
    private Member one;

    @ManyToOne
    @JoinColumn(name = "request_id")
    private Member two;

    public static Friend createFriendFair(Member one, Member two){
        return Friend.builder().one(one).two(two).build();
    }

    public FriendDTO toDTO(){
        FriendDTO friendDTO = new FriendDTO();
        friendDTO.setOne(this.one);
        friendDTO.setTwo(this.two);

        return friendDTO;
    }


    @Builder
    public Friend(Member one, Member two) {
        this.one = one;
        this.two = two;
    }
}
