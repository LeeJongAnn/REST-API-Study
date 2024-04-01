package com.api.prototype.board;


import com.api.prototype.entity.Board;
import com.api.prototype.entity.User;
import com.api.prototype.repository.BoardRepository;
import com.api.prototype.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BoardRepositoryTests {


    private BoardRepository boardRepository;
    private UserRepository userRepository;

    @Autowired
    public BoardRepositoryTests(BoardRepository boardRepository, UserRepository userRepository) {
        this.boardRepository = boardRepository;
        this.userRepository = userRepository;
    }

    @Test
    @DisplayName("게시글 생성 테스트")
    public void test1() {

        User user = userRepository.findByEmail("1111@naver.com");

        Board board = new Board().builder()
                .id(1)
                .title("제목입니다.")
                .content("내용입니다.")
                .user(user)
                .creationTime(new Date())
                .build();

        Board save = boardRepository.save(board);

        assertThat(save.getTitle()).isEqualTo("제목입니다.");
    }


}
