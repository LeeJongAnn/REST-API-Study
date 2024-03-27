package com.api.prototype.service.boardService;


import com.api.prototype.entity.Board;
import com.api.prototype.response.BoardResponse.BoardResponse;
import com.api.prototype.service.boardService.boardServiceImpl.Result;

import java.util.List;


public interface boardService {


    public BoardResponse createBoard(Board board);

    public Result getListBoard();
}
