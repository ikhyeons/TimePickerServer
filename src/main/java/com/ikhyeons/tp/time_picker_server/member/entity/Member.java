package com.ikhyeons.tp.time_picker_server.member.entity;

import com.ikhyeons.tp.time_picker_server.request.entity.Request;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Entity
@ToString
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long memberId;

    @Column(unique = true, nullable = false)
    private String id;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "member")
    private List<Request> request;

    //social login
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Column(nullable = false)
    private String socialId;

    @Builder
    public Member(String id, String password, String name, Role role, List<Request> request, SocialType socialType, String socialId) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.role = role;
        this.request = request;
        this.socialType = socialType;
        this.socialId = socialId;
    }
}
