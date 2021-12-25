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
@Table(name="t_usertype")
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_cd")
    private Long typeCd;

    @Description("유저관리권한")
    @Column(name = "mng_user_yn",columnDefinition = "boolean default false")
    private Boolean mngUserYn;

    @Description("게시판관리권한")
    @Column(name = "mng_board_yn",columnDefinition = "boolean default false")
    private Boolean mngBoardYn;





}
