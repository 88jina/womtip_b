package com.success.womtip.entity;

import jdk.jfr.Description;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name="t_user")
public class User {
    //TODO 토큰기반, 세션기반 모델이 다를 것 같아서 유저모델은 아직 미정

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_cd")
    private Long userCd;

    @Description("닉네임")
    @Column(name = "nickname")
    private String nickname;

    @Description("유저등급코드")
    @Column(name = "type_cd")
    private Long typeCd;
}
