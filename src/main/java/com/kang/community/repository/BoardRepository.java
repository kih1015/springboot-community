package com.kang.community.repository;

import com.kang.community.domain.Article;

import java.util.List;

public interface BoardRepository {

    List<Article> findAll();
    Article findById(Long id);
    Article save(Article article);
    Article update(Long id, Article article);
    void delete(Long id);

}
