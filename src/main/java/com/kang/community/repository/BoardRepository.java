package com.kang.community.repository;

import com.kang.community.data.entity.Board;

import java.util.List;

public interface BoardRepository {

    List<Board> readAll();
    Board readById(int id);
    void create(Board board);
    void delete(int id);

}
