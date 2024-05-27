package com.kang.community.service;

import com.kang.community.data.dto.ArticleCreateRequest;
import com.kang.community.data.dto.ArticleResponse;
import java.util.List;
import java.util.Map;

public interface ArticleService {
    Map<String, List<ArticleResponse>> readArticlesOnBoard();
    List<ArticleResponse> readArticles();
    ArticleResponse readArticleById(int id);
    void createArticle(ArticleCreateRequest dto);
    void updateArticleById(int id, String title, String content);
    void deleteArticleById(int id);
}
