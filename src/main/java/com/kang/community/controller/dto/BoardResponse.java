package com.kang.community.controller.dto;

import com.kang.community.domain.Board;

public record BoardResponse(Long id, String name) {
    public static BoardResponse from(Board board) {
        return new BoardResponse(board.getId(), board.getName());
    }
}
