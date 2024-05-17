package com.kang.community.data.repository;

import com.kang.community.data.entity.Article;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ArticleRepository {

    private final Map<Integer, Article> articleMap = new HashMap<>();

    public List<Article> readAll() {
        return new ArrayList<>(articleMap.values());
    }

    public Article readById(int id) {
        if (articleMap.containsKey(id)) {
            return articleMap.get(id);
        } else {
            throw new RuntimeException();
        }
    }

    public Article create(Article article) {
        return articleMap.put(article.getId(), article);
    }

    public Article updateTitleById(int id, String title) {
        if (articleMap.containsKey(id)) {
            articleMap.get(id).setTitle(title);
            return articleMap.get(id);
        } else {
            throw new RuntimeException();
        }
    }

    public Article updateContentById(int id, String content) {
        if (articleMap.containsKey(id)) {
            articleMap.get(id).setContent(content);
            return articleMap.get(id);
        } else {
            throw new RuntimeException();
        }
    }

    public void delete(int id) {
        if (articleMap.containsKey(id)) {
            articleMap.remove(id);
        } else {
            throw new RuntimeException();
        }
    }

}
