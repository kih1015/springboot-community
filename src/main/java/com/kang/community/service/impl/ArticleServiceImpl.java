package com.kang.community.service.impl;

import com.kang.community.controller.dto.ArticleCreateRequest;
import com.kang.community.controller.dto.ArticleResponse;
import com.kang.community.controller.dto.ArticleUpdateRequest;
import com.kang.community.domain.Article;
import com.kang.community.repository.ArticleRepository;
import com.kang.community.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<ArticleResponse> getAll() {
        return articleRepository.findAll().stream().map((ArticleResponse::from)).toList();
    }

    @Override
    public ArticleResponse getById(Long id) {
        return ArticleResponse.from(articleRepository.findById(id));
    }

    @Override
    public ArticleResponse create(ArticleCreateRequest req) {
        Article created = articleRepository.save(req.toArticle());
        return ArticleResponse.from(created);
    }

    @Override
    public ArticleResponse update(Long id, ArticleUpdateRequest req) {
        Article article = articleRepository.findById(id);
        article.update(req.board_id(), req.title(), req.content());
        Article updated = articleRepository.update(id, article);
        return ArticleResponse.from(updated);
    }

    @Override
    public void delete(Long id) {
        articleRepository.delete(id);
    }
}
