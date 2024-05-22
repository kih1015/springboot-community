package com.kang.community.service;

import com.kang.community.data.dto.ArticleRequestDto;
import com.kang.community.data.dto.ArticleResponseDto;
import java.util.List;
import java.util.Map;

public interface ArticleService {
    Map<String, List<ArticleResponseDto>> readArticlesOnBoard();
    List<ArticleResponseDto> readArticles();
    ArticleResponseDto readArticleById(int id);
    void createArticle(ArticleRequestDto dto);
    void updateArticleById(int id, String title, String content);
    void deleteArticleById(int id);
}
