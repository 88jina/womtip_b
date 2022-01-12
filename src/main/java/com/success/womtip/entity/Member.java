package com.success.womtip.entity;

import jdk.jfr.Description;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "t_member", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"member_id","nickname"})
})
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

    @Column(name = "email")
    private String email;

    @Description("유저구분")
    @Column(name = "roles")
    private String roles;

    @Description("유저등급코드")
    @Column(name = "type_cd")
    private Long typeCd;

    @Column(name = "last_login_dttm",  columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private LocalDateTime lastLoginDttm;

    @Column(name = "register_dttm" ,  columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private LocalDateTime registerDttm;


    // ENUM으로 안하고 ROLE을 입력한 후 따옴표(,)로 구분해서 파싱
    public List<String> getRoleList() {
        if (this.roles.length() > 0) return Arrays.asList(this.roles.split(","));
        return new ArrayList<>();
    }

}
