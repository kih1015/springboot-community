package com.kang.community.controller;

import com.kang.community.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class boardController {
    private final CommunityService communityService;

    @Autowired
    public boardController(CommunityService communityService) {
        this.communityService = communityService;
    }

    @PostMapping("/boards")
    public void createBoard(@RequestBody String name) {
        communityService.createBoard(name);
    }
}
