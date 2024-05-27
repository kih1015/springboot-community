package com.kang.community.controller.dto;

import com.kang.community.domain.Article;

import java.time.LocalDateTime;

public record ArticleCreateRequest(
        Long board_id,
        Long author_id,
        String title,
        String content) {

    public Article toArticle() {
        return new Article.Builder()
                .setAuthorId(author_id)
                .setBoardId(board_id)
                .setTitle(title)
                .setContent(content)
                .setCreatedAt(LocalDateTime.now())
                .build();
    }

}