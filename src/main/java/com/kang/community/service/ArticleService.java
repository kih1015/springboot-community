package com.kang.community.service;

import com.kang.community.controller.dto.ArticleCreateRequest;
import com.kang.community.controller.dto.ArticleResponse;
import com.kang.community.controller.dto.ArticleUpdateRequest;

import java.util.List;

public interface ArticleService {

    List<ArticleResponse> getAll();
    ArticleResponse getById(Long id);
    ArticleResponse create(ArticleCreateRequest req);
    ArticleResponse update(Long id, ArticleUpdateRequest req);
    void delete(Long id);

}
