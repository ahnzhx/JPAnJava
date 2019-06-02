package com.example.sonniespringdev.board.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Codes {
    @Id @GeneratedValue
    private String id;

    @ManyToOne
    private String code;



}
