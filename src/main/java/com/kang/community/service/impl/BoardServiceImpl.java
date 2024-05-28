package com.kang.community.service.impl;

import com.kang.community.controller.dto.BoardResponse;
import com.kang.community.repository.BoardRepository;
import com.kang.community.service.BoardService;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;

    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public BoardResponse getById(Long id) {
        return BoardResponse.from(boardRepository.findById(id));
    }
}
