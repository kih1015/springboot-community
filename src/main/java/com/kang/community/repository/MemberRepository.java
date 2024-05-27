package com.kang.community.repository;

import com.kang.community.domain.Member;

import java.util.List;

public interface MemberRepository {

    List<Member> readAll();
    Member readById(int id);
    void create(Member member);
    void delete(int id);

}
