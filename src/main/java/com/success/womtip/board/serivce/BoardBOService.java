package com.success.womtip.board.serivce;

import com.success.womtip.board.repository.BoardRepository;
import com.success.womtip.entity.Board;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BoardBOService {
    private final BoardRepository boardRepository;


    public BoardBOService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public List<Board> retrieveBoard(Long menuCd, String menuNm, int boardLv, Boolean blindYn) {
        return null;
    }
}
