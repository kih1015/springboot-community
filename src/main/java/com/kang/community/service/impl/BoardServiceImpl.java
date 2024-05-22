package com.kang.community.service.impl;

import com.kang.community.data.entity.Board;
import com.kang.community.data.repository.BoardRepository;
import com.kang.community.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;

    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }
    public void createBoard(String name) {
        Board board = new Board();
        board.setName(name);
        boardRepository.create(board);
    }
}
