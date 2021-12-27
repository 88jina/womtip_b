package com.success.womtip.board.serivce;

import com.success.womtip.board.repository.BoardRepository;
import com.success.womtip.board.repository.spec.BoardSpecs;
import com.success.womtip.entity.Board;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class BoardBOService {
    private final BoardRepository boardRepository;


    public BoardBOService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public List<Board> retrieveBoard(Long menuCd, String boardNm, Integer boardLv, Boolean blindYn) {
        Specification<Board> spec = Specification.where(BoardSpecs.delYnAndOrder(true));
        spec = spec.and(BoardSpecs.equalBlindYn(Objects.requireNonNullElse(blindYn, false)));
        if (boardNm != null) spec = spec.and(BoardSpecs.likeBoardNm(boardNm));
        if (menuCd != null) spec = spec.and(BoardSpecs.equalMenuCd(menuCd));
        if (boardLv != null) spec = spec.and(BoardSpecs.equalBoardLv(boardLv));
        return boardRepository.findAll(spec);
    }

    public boolean createBoard(Board board) {
        Board resultEntity = boardRepository.save(board);
        if (resultEntity.getBoardCd() != null) return true;
        return false;
    }

    public boolean updateMenu(Board board) {
        Board found = boardRepository.getById(board.getBoardCd());
        if(found.getBoardCd()!=null){
            boardRepository.save(board);
            return true;
        }
        return false;
    }

    public boolean deleteBoard(Long boardCd) {
        Board found = boardRepository.getById(boardCd);
        if(!ObjectUtils.isEmpty(found)) {
            found.setDelYn(true);
            boardRepository.save(found);
            return true;
        }
        return false;
    }
}
