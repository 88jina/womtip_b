package com.success.womtip.entity;

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
@Table(name = "t_post_tag_map")
public class PostTagMap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "map_cd")
    private Long mapCd;

    @Column(name = "tag_cd")
    private Long tagCd;

    @Column(name = "post_cd")
    private Long postCd;

    @ManyToOne
    @JoinColumn(name = "tag_cd",insertable = false,updatable = false)
    private Tag tag;

    @ManyToOne
    @JoinColumn(name = "post_cd", insertable = false, updatable = false)
    private Post post;

}
