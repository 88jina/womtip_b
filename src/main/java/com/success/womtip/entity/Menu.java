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
@Table(name="t_menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_cd")
    private Long menuCd;

    @Description("메뉴이름")
    @Column(name = "menu_nm", nullable = false)
    private String menuNm;

    @Description("전시여부")
    @Column(name = "blind_yn", columnDefinition = "boolean default false")
    private Boolean blindYn;

    @Description("삭제여부")
    @Column(name = "del_yn", columnDefinition = "boolean default false")
    private Boolean delYn;

    @Description("전시순서")
    @Column(name = "show_order")
    private int order;
}
