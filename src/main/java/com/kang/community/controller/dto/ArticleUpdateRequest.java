package com.kang.community.controller.dto;

public record ArticleUpdateRequest(
        Long board_id,
        String title,
        String content) {
}
