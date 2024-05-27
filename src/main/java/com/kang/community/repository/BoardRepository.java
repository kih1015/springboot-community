package com.kang.community.repository;

import com.kang.community.domain.Article;
import com.kang.community.domain.Board;

import java.util.List;

public interface BoardRepository {

    Board findById(Long id);

}
