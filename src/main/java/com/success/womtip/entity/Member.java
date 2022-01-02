package com.success.womtip.entity;

import jdk.jfr.Description;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name="t_member")
public class Member {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_cd")
    private Long memberCd;

    @Column(name = "member_id")
    private String memberId;

    @Column(name = "password")
    private String password;

    @Description("닉네임")
    @Column(name = "nickname")
    private String nickname;

    @Description("유저등급코드")
    @Column(name = "type_cd")
    private Long typeCd;

    @Column(name = "last_login_dttm")
    private LocalDateTime lastLoginDttm;

    @Column(name = "register_dttm")
    private LocalDateTime registerDttm;
}
