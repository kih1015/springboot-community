package com.kang.community.controller;

import com.kang.community.data.dto.MemberRequestDto;
import com.kang.community.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OthersController {
    private final CommunityService communityService;

    @Autowired
    public OthersController(CommunityService communityService) {
        this.communityService = communityService;
    }

    @PostMapping("/members")
    public void createMember(@RequestBody MemberRequestDto dto) {
        communityService.createMember(dto);
    }

    @PostMapping("/Boards")
    public void createBoard(@RequestBody String name) {
        communityService.createBoard(name);
    }

}
