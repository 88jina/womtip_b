package com.success.womtip.entity;

import com.success.womtip.utils.Bool2YNConverter;
import com.sun.istack.NotNull;
import jdk.jfr.Description;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="t_post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_cd")
    private Long postCd;

    @Description("게시판 코드")
    @Column(name = "board_cd")
    private Long boardCd;

    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "contents")
    private String contents;

    @NotNull
    @Convert(converter = Bool2YNConverter.class)
    @Column(name = "share_yn", columnDefinition = "boolean default false")
    private Boolean shareYn;

    @NotNull
    @Convert(converter = Bool2YNConverter.class)
    @Column(name = "search_yn", columnDefinition = "boolean default false")
    private Boolean searchYn;

    @ManyToOne
    @JoinColumn(name = "board_cd" , insertable = false, updatable = false)
    private Board board;

}
