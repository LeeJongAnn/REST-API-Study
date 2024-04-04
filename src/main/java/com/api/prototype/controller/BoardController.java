package com.api.prototype.controller;


import com.api.prototype.entity.Board;
import com.api.prototype.response.BoardResponse.BoardResponse;
import com.api.prototype.service.boardService.boardServiceImpl;
import com.api.prototype.service.boardService.boardServiceImpl.Result;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/api/deleteBoard/{id}")
    public ResponseEntity<?> deleteBoard(@PathVariable("id") Integer id) {

        boardService.deleteBoard(id);

        return ResponseEntity.ok().build();
    }
}
