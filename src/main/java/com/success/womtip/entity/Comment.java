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
@Table(name = "t_comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_cd")
    private Long commentCd;

    @Description("사용자코드")
    @Column(name = "user_cd", nullable = false)
    private Long userCd;

    @Description("원글코드")
    @Column(name = "post_cd", nullable = false)
    private Long postCd;

    @Description("상위댓글코드(대댓글기능 위한 코드)")
    @Column(name = "parent_cd")
    private Long parentCd;

    @Description("댓글내용")
    @Column(name = "contents", nullable = false)
    private String contents;

    @Description("비밀댓글여부")
    @Column(name = "blind_yn", nullable = false, columnDefinition = "boolean default false")
    private Boolean blindYn;

    @Description("생성날짜시간")
    @Column(name = "create_dttm", nullable = false)
    private LocalDateTime createDttm;

    @Description("수정날짜시간")
    @Column(name = "update_dttm", nullable = false)
    private LocalDateTime updateDttm;

    @OneToOne
    @JoinColumn(name = "post_cd", insertable = false, updatable = false)
    private Post post;

    @OneToOne
    @JoinColumn(name = "user_cd", insertable = false, updatable = false)
    private User user;


}
