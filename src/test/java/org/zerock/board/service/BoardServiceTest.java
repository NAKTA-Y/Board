package org.zerock.board.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.dto.PageRequestDTO;
import org.zerock.board.dto.PageResultDTO;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardServiceTest {

    @Autowired BoardService boardService;

    @Test
    public void testRegister() {

        BoardDTO dto = BoardDTO.builder()
                .title("TestTitle.")
                .content("TestContent.")
                .writerId(10L) // 데이터베이스 내에 존재하는 Member Id
                .build();

        Long bno = boardService.register(dto);
    }

    @Test
    public void testList() {

        PageRequestDTO pageRequestDTO = new PageRequestDTO();

        PageResultDTO<BoardDTO, Object[]> result = boardService.getList(pageRequestDTO);

        for (BoardDTO boardDTO : result.getDtoList()) {

            System.out.println(boardDTO);

        }

    }

}