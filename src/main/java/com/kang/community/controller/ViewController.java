package com.kang.community.controller;

import com.kang.community.controller.dto.ArticleResponse;
import com.kang.community.service.ArticleService;
import com.kang.community.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

@Controller
public class ViewController {

    private final ArticleService articleService;
    private final BoardService boardService;

    public ViewController(ArticleService articleService, BoardService boardService) {
        this.articleService = articleService;
        this.boardService = boardService;
    }

    @GetMapping("/posts")
    public String getPosts(@RequestParam("boardId") Long boardId, Model model) {
        String boardName = boardService.getById(boardId).name();
        List<ArticleResponse> articleList = articleService.getAll()
                .stream()
                .filter(articleResponse -> articleResponse.board_id().equals(boardId))
                .toList();
        System.out.println(boardName);
        model.addAttribute("boardName", boardName);
        model.addAttribute("articleList", articleList);
        return "posts";
    }

}
