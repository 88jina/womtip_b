package com.success.womtip.board.repository;

import com.success.womtip.entity.Board;
import com.sun.istack.Nullable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.relational.core.mapping.Embedded;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long>, JpaSpecificationExecutor<Board> {

    List<Board> findBoardsByMenuCd(Long menuCd);
    List<Board> findBoardsByBoardNmContaining(String boardNm);
    List<Board> findBoardsByBoardLv(int boardLv);
    List<Board> findBoardsByBlindYn(Boolean boardYn);

//    List<Board> findAll(@Nullable Specification<Board> spec);



}
