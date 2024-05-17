package com.kang.community.data.repository;

import com.kang.community.data.entity.Member;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MemberRepository {

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

    public Member create(Member member) {
        return boardMap.put(member.getId(), member);
    }

    public void delete(int id) {
        if (boardMap.containsKey(id)) {
            boardMap.remove(id);
        } else {
            throw new RuntimeException();
        }
    }

}
