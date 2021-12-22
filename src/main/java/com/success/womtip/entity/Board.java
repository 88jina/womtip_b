package com.success.womtip.entity;

import com.success.womtip.utils.Bool2YNConverter;
import com.sun.istack.NotNull;
import jdk.jfr.Description;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="t_board")
public class Board {
    @Id
    @Description("게시판 코드")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_cd")
    private Long boardCd;

    @NotNull
    @Description("게시판 이름")
    @Column(name = "board_nm")
    private String boardNm;

    @NotNull
    @Description("상위메뉴코드")
    @Column(name = "menu_cd", columnDefinition = "integer default 1")
    private int menuCd;

    @Description("게시판 레벨")
    @Column(name = "board_lv", columnDefinition = "integer default 0")
    private int boardLv;

    @Convert(converter = Bool2YNConverter.class)
    @Description("게시판 숨김 여부")
    @Column(name = "blind_yn", columnDefinition = "boolean default false")
    private Boolean blindYn;

    @Convert(converter = Bool2YNConverter.class)
    @Description("게시판 삭제 여부")
    @Column(name = "del_yn", columnDefinition = "boolean default false")
    private Boolean delYn;

    @ManyToOne
    @JoinColumn(name = "menu_cd", insertable = false, updatable = false)
    private Menu menu;



}
