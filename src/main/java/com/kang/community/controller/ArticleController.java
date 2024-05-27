package com.kang.community.controller;

import com.kang.community.controller.dto.ArticleCreateRequest;
import com.kang.community.controller.dto.ArticleResponse;
import com.kang.community.controller.dto.ArticleUpdateRequest;
import com.kang.community.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping()
    public ResponseEntity<List<ArticleResponse>> getArticles(@RequestParam("boardId") Long boardId) {
        List<ArticleResponse> articleList = articleService.getAll()
                .stream()
                .filter(articleResponse -> articleResponse.board_id().equals(boardId))
                .toList();
        return ResponseEntity.ok(articleList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleResponse> getArticleById(@PathVariable Long id) {
        ArticleResponse rsp = articleService.getById(id);
        return ResponseEntity.ok(rsp);
    }

    @PostMapping
    public ResponseEntity<Void> createArticle(@RequestBody ArticleCreateRequest req) {
        ArticleResponse rsp = articleService.create(req);
        return ResponseEntity.created(URI.create("/articles/" + rsp.id())).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticleResponse> updateArticle(@PathVariable Long id, @RequestBody ArticleUpdateRequest req) {
        ArticleResponse rsp = articleService.update(id, req);
        return ResponseEntity.ok(rsp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        articleService.delete(id);
        return ResponseEntity.noContent().build();
    }

}