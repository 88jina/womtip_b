package com.success.womtip.entity;

import jdk.jfr.Description;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="t_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_cd")
    private Long userCd;

    @Description("유저등급코드")
    @Column(name = "type_cd")
    private Long typeCd;
}
