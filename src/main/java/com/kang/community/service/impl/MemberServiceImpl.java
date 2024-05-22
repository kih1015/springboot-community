package com.kang.community.service.impl;

import com.kang.community.data.dto.MemberRequestDto;
import com.kang.community.data.entity.Member;
import com.kang.community.data.repository.MemberRepository;
import com.kang.community.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    public void createMember(MemberRequestDto dto) {
        Member member = new Member();
        member.setEmail(dto.getEmail());
        member.setName(dto.getName());
        member.setPassword(dto.getPassword());
        memberRepository.create(member);
    }
}
