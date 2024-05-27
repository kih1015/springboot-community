package com.kang.community.controller;

import com.kang.community.data.dto.MemberRequest;
import com.kang.community.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/members")
    public void createMember(@RequestBody MemberRequest dto) {
        memberService.createMember(dto);
    }
}
