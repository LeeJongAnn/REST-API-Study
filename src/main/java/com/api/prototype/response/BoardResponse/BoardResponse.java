package com.api.prototype.response.BoardResponse;

import com.api.prototype.entity.Board;
import com.api.prototype.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class BoardResponse {

    private Integer id;

    @NotNull
    private String title;

    @NotNull
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @Builder
    public BoardResponse(String title, String content, User user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user = user;
    }


    public BoardResponse() {

    }

    public BoardResponse ResponseToBoard(Board board) {

        BoardResponse boardResponse = builder()
                .title(board.getTitle())
                .content(board.getContent())
                .user(board.getUser())
                .build();
        return boardResponse;
    }


}
