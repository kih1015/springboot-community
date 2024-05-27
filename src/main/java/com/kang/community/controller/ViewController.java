package com.kang.community.controller;

import com.kang.community.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {

    private final ArticleService articleService;

    public ViewController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/posts")
    public String getPosts(Model model, @RequestParam("boardId") Long boardId) {
        model.addAttribute("postsMap", articleService.getAll());
        return "posts";
    }

}
