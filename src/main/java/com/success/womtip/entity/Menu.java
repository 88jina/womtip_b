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
    @Column(name = "show_yn", columnDefinition = "boolean default true")
    private Boolean showYn;

    @Description("전시순서")
    @Column(name = "show_order")
    private int order;
}
