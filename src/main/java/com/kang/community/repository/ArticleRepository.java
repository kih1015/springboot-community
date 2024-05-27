package com.kang.community.repository;

import com.kang.community.data.entity.Article;

import java.util.List;

public interface ArticleRepository {

    List<Article> findAll();
    Article findById(Long id);
    Article save(Article article);
    Article update(Long id, Article article);
    void delete(Long id);

}
