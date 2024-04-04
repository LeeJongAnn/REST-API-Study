package com.api.prototype.service.boardService;


import com.api.prototype.entity.Board;
import com.api.prototype.response.BoardResponse.BoardResponse;
import com.api.prototype.service.boardService.boardServiceImpl.Result;


public interface boardService {


    public BoardResponse createBoard(Board board);

    public Result getListBoard();

    public void deleteBoard(Integer id);

    public Board updateBoard(Integer id);
}
