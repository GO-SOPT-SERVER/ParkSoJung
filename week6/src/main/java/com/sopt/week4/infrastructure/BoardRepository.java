package com.sopt.week4.infrastructure;

import com.sopt.week4.domain.Board;
import org.springframework.data.repository.Repository;

public interface BoardRepository extends Repository<Board, Long> {

    // CREATE
    void save(Board board);
}
