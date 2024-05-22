package com.kang.community.controller;

import com.kang.community.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class boardController {
    private final BoardService boardService;

    @Autowired
    public boardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("/boards")
    public void createBoard(@RequestBody String name) {
        boardService.createBoard(name);
    }
}
