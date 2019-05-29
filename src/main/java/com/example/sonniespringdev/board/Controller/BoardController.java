package com.example.sonniespringdev.board.Controller;

import com.example.sonniespringdev.board.model.Board;
import com.example.sonniespringdev.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardRepository boardRepository;

    @GetMapping("/")
    public String boardList(Model model){
        String boardSetting = " now I'm setting my first board project.";
        model.addAttribute("boardSetting",boardSetting);
        return "BoardList";
    }

    @GetMapping("/create")
    public String createBoard(@RequestAttribute Board board){
        this.boardRepository.save(board);
        return "/";
    }
}
