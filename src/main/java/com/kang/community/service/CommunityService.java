package com.kang.community.service;

import com.kang.community.data.dto.ArticleRequestDto;
import com.kang.community.data.dto.ArticleResponseDto;
import com.kang.community.data.dto.MemberRequestDto;

import java.util.List;
import java.util.Map;

public interface CommunityService {
    Map<String, List<ArticleResponseDto>> readArticlesOnBoard();
    List<ArticleResponseDto> readArticles();
    ArticleResponseDto readArticleById(int id);
    void createArticle(ArticleRequestDto dto);
    void updateArticleById(int id, String title, String content);
    void deleteArticleById(int id);
    void createMember(MemberRequestDto dto);
    void createBoard(String name);

}
