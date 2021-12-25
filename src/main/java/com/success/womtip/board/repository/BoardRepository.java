package com.success.womtip.board.repository;

import com.success.womtip.entity.Board;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullApi;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long>, JpaSpecificationExecutor<Board> {

    @Override
    @NonNull
    List<Board> findAll(Specification<Board> spec);
}
