package com.api.prototype.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {


    @GetMapping("/api/createBoard")
    public ResponseEntity<?> createBoard() {


    }
}
