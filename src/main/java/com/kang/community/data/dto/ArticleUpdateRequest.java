package com.kang.community.data.dto;

public record ArticleUpdateRequest(
        Long boardId,
        String title,
        String content) {
}
