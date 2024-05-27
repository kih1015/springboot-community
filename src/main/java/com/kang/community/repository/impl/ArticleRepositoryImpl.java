package com.kang.community.repository.impl;

import com.kang.community.data.entity.Article;
import com.kang.community.repository.ArticleRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class ArticleRepositoryImpl implements ArticleRepository {

    private final JdbcTemplate jdbcTemplate;

    public ArticleRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Article> findAll() {
        return jdbcTemplate.query(
                "select * from article",
                (rs, row) -> new Article.Builder()
                        .setId(rs.getLong("id"))
                        .setAuthorId(rs.getLong("author_id"))
                        .setBoardId(rs.getLong("board_id"))
                        .setTitle(rs.getString("title"))
                        .setContent(rs.getString("content"))
                        .setCreatedAt(rs.getTimestamp("created_date").toLocalDateTime())
                        .setUpdatedAt(rs.getTimestamp("modified_date").toLocalDateTime())
                        .build());
    }

    @Override
    public Article findById(Long id) {
        return jdbcTemplate.queryForObject(
                "select * from article where id = ?",
                (rs, row) -> new Article.Builder()
                        .setId(rs.getLong("id"))
                        .setAuthorId(rs.getLong("author_id"))
                        .setBoardId(rs.getLong("board_id"))
                        .setTitle(rs.getString("title"))
                        .setContent(rs.getString("content"))
                        .setCreatedAt(rs.getTimestamp("created_date").toLocalDateTime())
                        .setUpdatedAt(rs.getTimestamp("modified_date").toLocalDateTime())
                        .build(), id);
    }

    @Override
    public Article save(Article article) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(
                    "insert into article (author_id, board_id, title, content, created_date) value (?, ?, ?, ?, ?)",
                    new String[]{"id"});
            ps.setLong(1, article.getAuthorId());
            ps.setLong(2, article.getBoardId());
            ps.setString(3, article.getTitle());
            ps.setString(4, article.getContent());
            ps.setTimestamp(5, Timestamp.valueOf(article.getCreatedAt()));
            return ps;
        }, keyHolder);
        return findById(keyHolder.getKey().longValue());
    }

    @Override
    public Article update(Long id, Article article) {
        jdbcTemplate.update(
                "update article set board_id = ?, title = ?, content = ?, modified_date = ? where id = ?",
                article.getBoardId(), article.getTitle(), article.getContent(), article.getUpdatedAt(), article.getId());
        return findById(article.getId());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("delete from article where id = ?", id);
    }

}
