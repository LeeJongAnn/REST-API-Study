package com.api.prototype.controller;


import com.api.prototype.entity.Board;
import com.api.prototype.response.BoardResponse.BoardResponse;
import com.api.prototype.service.boardService.boardServiceImpl;
import com.api.prototype.service.boardService.boardServiceImpl.Result;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {


    @Autowired
    private boardServiceImpl boardService;

    @PostMapping("/api/createBoard")
    public ResponseEntity<?> postBoard(@RequestBody @Valid Board board) {

        BoardResponse savedBoard = boardService.createBoard(board);

        return ResponseEntity.ok(savedBoard);
    }

    @GetMapping("/api/listAllBoard")
    public ResponseEntity<?> getListBoard() {

        Result listBoard = boardService.getListBoard();

        return ResponseEntity.ok(listBoard);
    }


}
