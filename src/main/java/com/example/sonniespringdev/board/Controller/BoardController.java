package com.example.sonniespringdev.board.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {


    @GetMapping("/board")
    public String boardList(Model model){
        String boardSetting = " now I'm setting my first board project.";
        model.addAttribute("boardSetting",boardSetting);
        return "Board";
    }
}
