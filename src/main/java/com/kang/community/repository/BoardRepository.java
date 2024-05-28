package com.kang.community.repository;

import com.kang.community.domain.Board;

public interface BoardRepository {

    Board findById(Long id);

}
