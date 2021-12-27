package com.success.womtip.board.controller;

import com.success.womtip.board.serivce.BoardBOService;
import com.success.womtip.entity.Board;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bo/board")
public class BoardBOController {

    private final BoardBOService boardBOService;

    public BoardBOController(BoardBOService boardBOService) {
        this.boardBOService = boardBOService;
    }

    @GetMapping
    public List<Board> retrieveBoards(@RequestParam(required = false) Long menuCd,
                                      @RequestParam(required = false) String boardNm,
                                      @RequestParam(required = false) Integer boardLv,
                                      @RequestParam(required = false) Boolean blindYn) {
        return boardBOService.retrieveBoard(menuCd, boardNm, boardLv, blindYn);
    }

    @PostMapping
    public ResponseEntity<Void> createBoard(@RequestBody Board board){
        if(ObjectUtils.isEmpty(board))return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if(!boardBOService.createBoard(board)) return new ResponseEntity<>(HttpStatus.CONFLICT);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> updateBoard(@RequestBody Board board){
        if(ObjectUtils.isEmpty(board))return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if(!boardBOService.updateMenu(board)) return new ResponseEntity<>(HttpStatus.CONFLICT);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteBoard(@RequestParam Long boardCd){
        if(!boardBOService.deleteBoard(boardCd)) return new ResponseEntity<>(HttpStatus.CONFLICT);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
