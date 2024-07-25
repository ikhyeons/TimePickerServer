package com.ikhyeons.tp.time_picker_server.request.entity;

import com.ikhyeons.tp.time_picker_server.member.entity.Member;
import com.ikhyeons.tp.time_picker_server.member.entity.Role;
import com.ikhyeons.tp.time_picker_server.member.entity.SocialType;
import com.ikhyeons.tp.time_picker_server.rDate.entity.RDate;
import com.ikhyeons.tp.time_picker_server.rDay.entity.RDay;
import com.ikhyeons.tp.time_picker_server.request_receiver.entity.RequestReceiver;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@ToString
@NoArgsConstructor
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long requestId;

    @ManyToOne
    @JoinColumn(name ="member_id")
    private Member member;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String deadline;

    @OneToMany(mappedBy = "request")
    @Cascade(CascadeType.ALL)
    private List<RequestReceiver> receiverList;

    @OneToMany(mappedBy = "request")
    @Cascade(CascadeType.ALL)
    private List<RDay> dayList;

    @OneToMany(mappedBy = "request")
    @Cascade(CascadeType.ALL)
    private List<RDate> dateList;

    @Column(nullable = false)
    private boolean isCancel;

    @Column(nullable = true)
    private String result;

    public void cancelRequest(){
        this.isCancel = true;
    }
    public static Request makeDayRequest(Member member) {
        return Request.builder()
                .member(member)
                .title("회의 일정 정하기")
                .description("자동자 개발 관련 회의 일정을 잡아야 합니다.")
                .deadline("2024-07-22")
                .type(Type.DAY)
                .dayList(new ArrayList<RDay>())
                .receiverList(new ArrayList<RequestReceiver>())
                .isCancel(false)
                .build();
    }
    public static Request makeDateRequest(Member member) {
        return Request.builder()
                .member(member)
                .title("회의 일정 정하기")
                .description("자동자 개발 관련 회의 일정을 잡아야 합니다.")
                .deadline("2024-07-22")
                .type(Type.DATE)
                .dateList(new ArrayList<RDate>())
                .receiverList(new ArrayList<RequestReceiver>())
                .isCancel(false)
                .build();
    }

    public void addReceiver(RequestReceiver requestReceiver){
        this.receiverList.add(requestReceiver);
    }
    public void deleteReceiver(RequestReceiver requestReceiver){
        this.receiverList.remove(requestReceiver);
    }

    public void addRDay(RDay rDay){
        this.dayList.add(rDay);
    }

    public void deleteRDay(RDay rDay){
        this.dayList.remove(rDay);
    }

    public void addRDate(RDate rDate){
        this.dateList.add(rDate);
    }

    public void deleteRDate(RDate rDate){
        this.dateList.remove(rDate);
    }
    @Builder
    public Request(Member member, Type type, String title, String description, String deadline, List<RequestReceiver> receiverList, List<RDay> dayList, List<RDate> dateList, String result, boolean isCancel) {
        this.member = member;
        this.type = type;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.receiverList = receiverList;
        this.dayList = dayList;
        this.dateList = dateList;
        this.isCancel = isCancel;
        this.result = result;
    }
}
