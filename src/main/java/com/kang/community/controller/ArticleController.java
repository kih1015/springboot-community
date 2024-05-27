package com.kang.community.controller;

import com.kang.community.controller.dto.ArticleCreateRequest;
import com.kang.community.controller.dto.ArticleResponse;
import com.kang.community.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public List<ArticleResponse> readArticles() {
        return articleService.readArticles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleResponse> readArticleById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(articleService.readArticleById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public void createArticle(@RequestBody ArticleCreateRequest dto) {
        articleService.createArticle(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticleResponse> updateArticleById(@PathVariable int id, @RequestBody Map<String, String> map) {
        try {
            articleService.updateArticleById(id, map.get("title"), map.get("content"));
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ArticleResponse> deleteArticleById(@PathVariable int id) {
        try {
            articleService.deleteArticleById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}