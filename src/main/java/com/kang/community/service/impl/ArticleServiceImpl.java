package com.kang.community.service.impl;

import com.kang.community.data.dto.ArticleCreateRequest;
import com.kang.community.data.dto.ArticleResponse;
import com.kang.community.data.entity.Article;
import com.kang.community.data.entity.Board;
import com.kang.community.data.repository.ArticleRepository;
import com.kang.community.data.repository.BoardRepository;
import com.kang.community.data.repository.MemberRepository;
import com.kang.community.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository, BoardRepository boardRepository, MemberRepository memberRepository) {
        this.articleRepository = articleRepository;
        this.boardRepository = boardRepository;
        this.memberRepository = memberRepository;
    }

    public Map<String, List<ArticleResponse>> readArticlesOnBoard() {
        Map<String, List<ArticleResponse>> map = new HashMap<>();
        for (Board board : boardRepository.readAll()) {
            map.put(board.getName(), new ArrayList<>());
        }
        for (Article article : articleRepository.readAll()) {
            String key = boardRepository.readById(article.getBoardId()).getName();
            ArticleResponse dto = new ArticleResponse();
            dto.setTitle(article.getTitle());
            dto.setAuthor(memberRepository.readById(article.getMemberId()).getName());
            dto.setDate(article.getCreatedAt());
            dto.setContent(article.getContent());
            map.get(key).add(dto);
        }
        return map;
    }

    public List<ArticleResponse> readArticles() {
        List<ArticleResponse> dtoList = new ArrayList<>();
        for (Article article : articleRepository.readAll()) {
            ArticleResponse dto = new ArticleResponse();
            dto.setTitle(article.getTitle());
            dto.setAuthor(memberRepository.readById(article.getMemberId()).getName());
            dto.setDate(article.getCreatedAt());
            dto.setContent(article.getContent());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public ArticleResponse readArticleById(int id) {
        ArticleResponse dto = new ArticleResponse();
        Article article = articleRepository.readById(id);
        dto.setTitle(article.getTitle());
        dto.setAuthor(memberRepository.readById(article.getMemberId()).getName());
        dto.setDate(article.getCreatedAt());
        dto.setContent(article.getContent());
        return dto;
    }

    public void createArticle(ArticleCreateRequest dto) {
        Article article = new Article();
        article.setMemberId(dto.getAuthorId());
        article.setBoardId(dto.getBoardId());
        article.setTitle(dto.getTitle());
        article.setContent(dto.getContent());
        article.setCreatedAt(Instant.now());
        article.setUpdatedAt(null);
        articleRepository.create(article);
    }

    public void updateArticleById(int id, String title, String content) {
        if (title != null) {
            articleRepository.updateTitleById(id, title);
        }
        if (content != null) {
            articleRepository.updateContentById(id, content);
        }
    }

    public void deleteArticleById(int id) {
        articleRepository.delete(id);
    }
}
