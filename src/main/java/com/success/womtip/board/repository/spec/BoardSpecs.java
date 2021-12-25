package com.success.womtip.board.repository.spec;

import com.success.womtip.entity.Board;
import org.springframework.data.jpa.domain.Specification;

public class BoardSpecs {

    public static Specification<Board> likeBoardNm(final String boardNm) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("boardNm"), "%" + boardNm + "%");
    }

    public static Specification<Board> equalMenuCd(final Long menuCd) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("menuCd"),  menuCd );
    }


    public static Specification<Board> equalBlindYn(final Boolean blindYn) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("blindYn"),  blindYn );
    }

    public static Specification<Board> equalBoardLv(final int boardLv) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("boardLv"),  boardLv );
    }


}
