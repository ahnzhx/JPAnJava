package com.example.sonniespringdev.board.repository;

import com.example.sonniespringdev.board.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
