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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "board_cd")
    private Long boardCd;

    @NotNull
    @Description("게시판 이름")
    @Column(name = "board_nm")
    private String boardNm;

    @NotNull
    @Description("상위메뉴코드")
    @Column(name = "parent_menu_cd", columnDefinition = "integer default 1")
    private int parentMenuCd;

    @Convert(converter = Bool2YNConverter.class)
    @Description("게시판 숨김 여부")
    @Column(name = "blind_yn", columnDefinition = "boolean default false")
    private Boolean blindYn;

    @Convert(converter = Bool2YNConverter.class)
    @Description("게시판 삭제 여부")
    @Column(name = "del_yn", columnDefinition = "boolean default false")
    private Boolean delYn;

}
