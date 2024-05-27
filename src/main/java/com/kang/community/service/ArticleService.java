package com.kang.community.service;

import com.kang.community.data.dto.ArticleCreateRequest;
import com.kang.community.data.dto.ArticleResponse;
import com.kang.community.data.dto.ArticleUpdateRequest;

import java.util.List;

public interface ArticleService {

    List<ArticleResponse> getAll();
    ArticleResponse getById(Long id);
    ArticleResponse create(ArticleCreateRequest req);
    ArticleResponse update(Long id, ArticleUpdateRequest req);
    void delete(Long id);

}
