package com.kang.community.data.repository;

import com.kang.community.data.entity.Article;

import java.util.List;

public interface ArticleRepository {

    List<Article> readAll();
    Article readById(int id);
    void create(Article article);
    void updateTitleById(int id, String title);
    void updateContentById(int id, String content);
    void delete(int id);

}
