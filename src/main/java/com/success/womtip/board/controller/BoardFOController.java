package com.success.womtip.board.controller;

import com.success.womtip.entity.Board;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fo/board")
public class BoardFOController {
    @GetMapping("")
    public List<Board> retrieveBoard(){

        return null;
    }
}
