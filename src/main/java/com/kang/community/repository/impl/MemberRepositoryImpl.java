package com.kang.community.repository.impl;

import com.kang.community.domain.Member;
import com.kang.community.repository.MemberRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemberRepositoryImpl implements MemberRepository {

    private final Map<Integer, Member> boardMap = new HashMap<>();

    public List<Member> readAll() {
        return new ArrayList<>(boardMap.values());
    }

    public Member readById(int id) {
        if (boardMap.containsKey(id)) {
            return boardMap.get(id);
        } else {
            throw new RuntimeException();
        }
    }

    public void create(Member member) {
        boardMap.put(member.getId(), member);
    }

    public void delete(int id) {
        if (boardMap.containsKey(id)) {
            boardMap.remove(id);
        } else {
            throw new RuntimeException();
        }
    }

}
