package org.zerock.board.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.board.entity.Board;
import org.zerock.board.entity.Member;
import org.zerock.board.entity.Reply;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReplyRepositoryTest {

    @Autowired ReplyRepository replyRepository;
    @Autowired BoardRepository boardRepository;
    @Autowired MemberRepository memberRepository;

    @Test
    public void insertReplyTest() {

        IntStream.rangeClosed(1, 100).forEach(i -> {

            Member member = Member.builder()
                    .email("user" + i + "@aaa.com")
                    .password("1111")
                    .name("USER" + i)
                    .build();

            memberRepository.save(member);

            Board board = Board.builder()
                    .title("Title..." + i)
                    .content("Content..." + i)
                    .member(member)
                    .build();

            boardRepository.save(board);

            IntStream.rangeClosed(1, 4).forEach(j -> {

                Reply reply = Reply.builder()
                        .text("Reply...." + i)
                        .board(board)
                        .replyer("guest")
                        .build();

                replyRepository.save(reply);
            });
        });
    }

}