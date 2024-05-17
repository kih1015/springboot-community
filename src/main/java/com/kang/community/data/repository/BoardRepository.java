package com.kang.community.data.repository;

import com.kang.community.data.entity.Board;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BoardRepository {

    private final Map<Integer, Board> boardMap = new HashMap<>();

    public List<Board> readAll() {
        return new ArrayList<>(boardMap.values());
    }

    public Board readById(int id) {
        if (boardMap.containsKey(id)) {
            return boardMap.get(id);
        } else {
            throw new RuntimeException();
        }
    }

    public void create(Board board) {
        boardMap.put(board.getId(), board);
    }

    public void delete(int id) {
        if (boardMap.containsKey(id)) {
            boardMap.remove(id);
        } else {
            throw new RuntimeException();
        }
    }

}
