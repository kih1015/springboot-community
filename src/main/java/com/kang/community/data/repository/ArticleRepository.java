package com.kang.community.data.repository;

import com.kang.community.data.entity.Article;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ArticleRepository {

    private int idCount = 1;
    private final Map<Integer, Article> articleMap = new HashMap<>();

    public List<Article> readAll() {
        return new ArrayList<>(articleMap.values());
    }

    public Article readById(int id) throws Exception {
        if (articleMap.containsKey(id)) {
            return articleMap.get(id);
        } else {
            throw new Exception();
        }
    }

    public Article create(Article article) {
        article.setId(idCount);
        return articleMap.put(idCount++, article);
    }

    public Article updateTitle(int id, String title) throws Exception {
        if (articleMap.containsKey(id)) {
            articleMap.get(id).setTitle(title);
            return articleMap.get(id);
        } else {
            throw new Exception();
        }
    }

    public Article updateContent(int id, String content) throws Exception {
        if (articleMap.containsKey(id)) {
            articleMap.get(id).setContent(content);
            return articleMap.get(id);
        } else {
            throw new Exception();
        }
    }

    public void delete(int id) throws Exception {
        if (articleMap.containsKey(id)) {
            articleMap.remove(id);
        } else {
            throw new Exception();
        }
    }

}
