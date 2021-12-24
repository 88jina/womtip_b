package com.success.womtip.board.controller;

import com.success.womtip.board.serivce.BoardBOService;
import com.success.womtip.entity.Board;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardBOController {

    private final BoardBOService boardBOService;

    public BoardBOController(BoardBOService boardBOService) {
        this.boardBOService = boardBOService;
    }

    @GetMapping("/")
    public List<Board> retrieveBoards(@RequestParam(required = false) Long menuCd,
                                      @RequestParam(required = false) String boardNm,
                                      @RequestParam(required = false) int boardLv,
                                      @RequestParam(required = false) Boolean blindYn) {
        return null;
    }


}
