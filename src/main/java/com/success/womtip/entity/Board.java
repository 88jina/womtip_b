package com.success.womtip.entity;

import com.success.womtip.utils.Bool2YNConverter;
import com.sun.istack.NotNull;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "board_cd")
    private Long boardCd;

    @Column(name = "depth", columnDefinition = "integer default 1")
    private int depth;

}
