package com.kang.community.data.dto;

public record ArticleUpdateRequest(
        Long board_id,
        String title,
        String content) {
}
