package com.example.sonniespringdev.board;

import lombok.Data;

@Data
public class BoardVo {
    private int bno;
    private String title;
    private String content;
    private String ip;
    private int see;
    private String rgstDt;
    private String updtDt;

}
