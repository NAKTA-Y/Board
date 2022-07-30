package org.zerock.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.dto.PageRequestDTO;
import org.zerock.board.service.BoardService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board/")
@Log4j2
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public String list(PageRequestDTO requestDTO, Model model) {

        log.info("list........." + requestDTO);

        model.addAttribute("result", boardService.getList(requestDTO));

        return "/board/list";
    }

    @GetMapping("/register")
    public String register() {

        log.info("regitser get.........");

        return "/board/register";
    }

    @PostMapping("/register")
    public String registerPost(BoardDTO dto, RedirectAttributes redirectAttributes) {

        log.info("dto........." + dto);

        Long bno = boardService.register(dto);

        log.info("BNO: " + bno);

        redirectAttributes.addFlashAttribute("msg", bno);

        return "redirect:/board/list";
    }
}
