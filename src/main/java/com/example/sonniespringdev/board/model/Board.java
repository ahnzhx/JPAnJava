package com.example.sonniespringdev.board.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Board {
    @Id @GeneratedValue
    private Long boardId;

    private String boardTitle;

    @Lob
    private String boardContent;

    @Temporal(TemporalType.TIMESTAMP)
    private Date rgDate;

    @ManyToOne
    private Authors account;

    @OneToMany(mappedBy = "code")
    private List<String> boardCode = new ArrayList<>();

    @Transient
    private String codeName;


}
