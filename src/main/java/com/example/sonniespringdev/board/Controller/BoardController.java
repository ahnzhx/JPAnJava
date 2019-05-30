package com.example.sonniespringdev.board.Controller;

import com.example.sonniespringdev.board.model.Board;
import com.example.sonniespringdev.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
        return "board";
    }

    @GetMapping("/update/{id}")
    public String updateBoard(
            @PathVariable Long id,
            Model model){
        Optional<Board> resultBoard = boardRepository.findById(id);
        model.addAttribute("resultBoard", resultBoard);
        return "/update/"+id;
    }

    @PostMapping("/update")
    public String update(@RequestAttribute Board boardForm){

        boardRepository.save(boardForm);
        return "board";
    }
}
