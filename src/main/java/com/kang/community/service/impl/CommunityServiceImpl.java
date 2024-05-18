package com.kang.community.service.impl;

import com.kang.community.data.dto.ArticleRequestDto;
import com.kang.community.data.dto.ArticleResponseDto;
import com.kang.community.data.dto.MemberRequestDto;
import com.kang.community.data.entity.Article;
import com.kang.community.data.entity.Board;
import com.kang.community.data.entity.Member;
import com.kang.community.data.repository.ArticleRepository;
import com.kang.community.data.repository.BoardRepository;
import com.kang.community.data.repository.MemberRepository;
import com.kang.community.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommunityServiceImpl implements CommunityService {

    private final ArticleRepository articleRepository;
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public CommunityServiceImpl(ArticleRepository articleRepository, BoardRepository boardRepository, MemberRepository memberRepository) {
        this.articleRepository = articleRepository;
        this.boardRepository = boardRepository;
        this.memberRepository = memberRepository;
    }

    public Map<String, List<ArticleResponseDto>> readArticlesOnBoard() {
        Map<String, List<ArticleResponseDto>> map = new HashMap<>();
        for (Board board : boardRepository.readAll()) {
            map.put(board.getName(), new ArrayList<>());
        }
        for (Article article : articleRepository.readAll()) {
            String key = boardRepository.readById(article.getBoardId()).getName();
            ArticleResponseDto dto = new ArticleResponseDto();
            dto.setTitle(article.getTitle());
            dto.setAuthor(memberRepository.readById(article.getMemberId()).getName());
            dto.setDate(article.getCreatedAt());
            dto.setContent(article.getContent());
            map.get(key).add(dto);
        }
        return map;
    }

    public List<ArticleResponseDto> readArticles() {
        List<ArticleResponseDto> dtoList = new ArrayList<>();
        for (Article article : articleRepository.readAll()) {
            ArticleResponseDto dto = new ArticleResponseDto();
            dto.setTitle(article.getTitle());
            dto.setAuthor(memberRepository.readById(article.getMemberId()).getName());
            dto.setDate(article.getCreatedAt());
            dto.setContent(article.getContent());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public ArticleResponseDto readArticleById(int id) {
        ArticleResponseDto dto = new ArticleResponseDto();
        Article article = articleRepository.readById(id);
        dto.setTitle(article.getTitle());
        dto.setAuthor(memberRepository.readById(article.getMemberId()).getName());
        dto.setDate(article.getCreatedAt());
        dto.setContent(article.getContent());
        return dto;
    }

    public void createArticle(ArticleRequestDto dto) {
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

    public void createMember(MemberRequestDto dto) {
        Member member = new Member();
        member.setEmail(dto.getEmail());
        member.setName(dto.getName());
        member.setPassword(dto.getPassword());
        memberRepository.create(member);
    }

    public void createBoard(String name) {
        Board board = new Board();
        board.setName(name);
        boardRepository.create(board);
    }

}
