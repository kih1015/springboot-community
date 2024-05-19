package com.kang.community.controller;

import com.kang.community.data.dto.ArticleRequestDto;
import com.kang.community.data.dto.ArticleResponseDto;
import com.kang.community.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/articles")
public class ArticleController {

    private final CommunityService communityService;

    @Autowired
    public ArticleController(CommunityService communityService) {
        this.communityService = communityService;
    }

    @GetMapping()
    public List<ArticleResponseDto> readArticles() {
        return communityService.readArticles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleResponseDto> readArticleById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(communityService.readArticleById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public void createArticle(@RequestBody ArticleRequestDto dto) {
        communityService.createArticle(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticleResponseDto> updateArticleById(@PathVariable int id, @RequestBody Map<String, String> map) {
        try {
            communityService.updateArticleById(id, map.get("title"), map.get("content"));
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ArticleResponseDto> deleteArticleById(@PathVariable int id) {
        try {
            communityService.deleteArticleById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}