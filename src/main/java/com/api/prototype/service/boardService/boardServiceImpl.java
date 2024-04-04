package com.api.prototype.service.boardService;


import com.api.prototype.Exception.BoardNotFoundException;
import com.api.prototype.entity.Board;
import com.api.prototype.repository.BoardRepository;
import com.api.prototype.response.BoardResponse.BoardResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class boardServiceImpl implements boardService{


    @Autowired
    private BoardRepository repository;

    @Override
    public BoardResponse createBoard(Board board) {


        Board saveBoard = repository.save(board);
        return new BoardResponse().ResponseToBoard(saveBoard);
    }


    @Override
    public Result getListBoard() {

        List<Board> boardList = (List<Board>) repository.findAll();

        List<BoardResponse> boardResponses = boardList.stream()
                .map(board -> new BoardResponse(board.getTitle(), board.getContent(), board.getUser()))
                .collect(Collectors.toList());

        return new Result(boardResponses.size(), boardResponses);

    }

    @Override
    public void deleteBoard(Integer id) {
        Board findBoard = repository.findById(id).orElseThrow(BoardNotFoundException::new);
        repository.deleteById(id);
    }

    @Override
    public Board updateBoard(Integer id) {
        return null;
    }

    @Data
    @AllArgsConstructor
    public static class Result<T> {
        private int count;
        private T data;
    }

}
