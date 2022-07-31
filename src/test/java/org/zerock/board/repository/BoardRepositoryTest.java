package org.zerock.board.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.board.entity.Board;
import org.zerock.board.entity.Member;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class BoardRepositoryTest {

    @Autowired BoardRepository boardRepository;
    @Autowired MemberRepository memberRepository;

    @Test
    public void insertBoardsTest() {

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
                    .writer(member)
                    .build();

            boardRepository.save(board);
        });
    }

    @Test
    @Rollback(value = false)
    public void testReadWithWriter() {

        Object result = boardRepository.getBoardWithWriter(100L);

        Object[] arr = (Object[])result;

        System.out.println("---------------------------------");
        System.out.println(Arrays.toString(arr));
    }

    @Test
    @Rollback(value = false)
    public void testGetBoardWithReply() {

        List<Object[]> result = boardRepository.getBoardWithReply(100L);

        for (Object[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }

    @Test
    @Rollback(value = false)
    public void testWithReplyCount() {

        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by("bno").descending());

        Page<Object[]> result = boardRepository.getBoardWithReplyCount(pageRequest);

        result.get().forEach(row -> {

            Object[] arr = (Object[])row;

            System.out.println(Arrays.toString(arr));

        });
    }

    @Test
    @Rollback(value = false)
    public void testRead() {

        Object result = boardRepository.getBoardByBno(100L);

        Object[] arr = (Object[])result;

        System.out.println(Arrays.toString(arr));

    }

    @Test
    public void testSearch1() {

        boardRepository.search1();
    }

    @Test
    public void testSearchPage() {

        Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending()
                .and(Sort.by("title").descending()));

        Page<Object[]> result = boardRepository.searchPage("t", "1", pageable);
    }
}