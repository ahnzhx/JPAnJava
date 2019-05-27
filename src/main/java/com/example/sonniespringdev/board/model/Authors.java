package com.example.sonniespringdev.board.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Authors {
    @Id @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private Set<Board> boardSet = new HashSet<>();

}
