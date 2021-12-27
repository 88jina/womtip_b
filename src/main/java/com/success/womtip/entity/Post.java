package com.success.womtip.entity;

import com.sun.istack.NotNull;
import jdk.jfr.Description;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "t_post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_cd")
    private Long postCd;

    @Description("게시판 코드")
    @Column(name = "board_cd", nullable = false)
    private Long boardCd;

    @Description("유저 코드")
    @Column(name = "user_cd", nullable = false)
    private Long userCd;

    @Description("유저 닉네임")
    @Column(name = "nickname")
    private String nickname;

    @NotNull
    @Column(name = "contents")
    private String contents;

    @Description("생성날짜시간")
    @Column(name = "create_dttm", nullable = false)
    private LocalDateTime createDttm;

    @Description("수정날짜시간")
    @Column(name = "update_dttm", nullable = false)
    private LocalDateTime updateDttm;

    @ManyToOne
    @JoinColumn(name = "board_cd" , insertable = false, updatable = false)
    private Board board;

    @OneToOne
    @JoinColumns({
            @JoinColumn(name = "user_cd", referencedColumnName = "user_cd", insertable = false, updatable = false),
            @JoinColumn(name = "nickname", referencedColumnName = "nickname", insertable = false, updatable = false)
    })
    private User user;

    @OneToMany
    @JoinColumn(name = "comment_cd")
    private List<Comment> comments;

    @OneToMany
    @JoinColumn(name = "map_cd")
    private List<PostTagMap> postTagMaps;

}
