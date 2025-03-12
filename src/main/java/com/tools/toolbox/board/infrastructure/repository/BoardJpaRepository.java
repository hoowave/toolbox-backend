package com.tools.toolbox.board.infrastructure.repository;

import com.tools.toolbox.board.core.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardJpaRepository extends JpaRepository<Board, Long> {
    
}
