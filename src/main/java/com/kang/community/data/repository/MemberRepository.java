package com.kang.community.data.repository;

import com.kang.community.data.entity.Member;

import java.util.List;

public interface MemberRepository {

    List<Member> readAll();
    Member readById(int id);
    void create(Member member);
    void delete(int id);

}
