package com.kang.community.service;

import com.kang.community.controller.dto.BoardResponse;

public interface BoardService {

    BoardResponse getById(Long id);

}
