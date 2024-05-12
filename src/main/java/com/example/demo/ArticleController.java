package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/article")
public class ArticleController {

    private final Map<Integer, Article> articleMap = new HashMap<>();
    private int idCount = 1;

    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable int id) {
        if (articleMap.containsKey(id)) {
            return ResponseEntity.ok(articleMap.get(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Object> createArticle(@RequestBody Article article) {
        if (article.getDescription() != null && article.getName() != null) {
            articleMap.put(idCount++, article);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticleById(@PathVariable int id, @RequestBody Article article) {
        if (articleMap.containsKey(id) && article.getDescription() != null && article.getName() != null) {
            articleMap.put(id, article);
            return ResponseEntity.ok(article);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteArticleById(@PathVariable int id) {
        if (articleMap.containsKey(id)) {
            articleMap.remove(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}