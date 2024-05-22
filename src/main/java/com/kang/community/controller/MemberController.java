package com.kang.community.controller;

import com.kang.community.data.dto.MemberRequestDto;
import com.kang.community.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
    private final CommunityService communityService;

    @Autowired
    public MemberController(CommunityService communityService) {
        this.communityService = communityService;
    }

    @PostMapping("/members")
    public void createMember(@RequestBody MemberRequestDto dto) {
        communityService.createMember(dto);
    }
}
