package com.kang.community.repository.impl;

import com.kang.community.controller.dto.BoardResponse;
import com.kang.community.domain.Article;
import com.kang.community.domain.Board;
import com.kang.community.repository.BoardRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BoardRepositoryImpl implements BoardRepository {
    private final JdbcTemplate jdbcTemplate;

    public BoardRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Board findById(Long id) {
        return jdbcTemplate.queryForObject(
                "select * from board where id = ?",
                (rs, row) -> new Board(rs.getLong("id"), rs.getString("name")), id);
    }

}
