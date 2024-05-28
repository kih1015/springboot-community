package com.kang.community.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kang.community.domain.Article;

import java.time.LocalDateTime;

public record ArticleResponse(
        Long id,
        Long author_id,
        Long board_id,
        String title,
        String content,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime created_date,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime modified_date) {

    public static ArticleResponse from(Article article) {
        return new ArticleResponse(
                article.getId(),
                article.getAuthorId(),
                article.getBoardId(),
                article.getTitle(),
                article.getContent(),
                article.getCreatedAt(),
                article.getUpdatedAt());
    }

}