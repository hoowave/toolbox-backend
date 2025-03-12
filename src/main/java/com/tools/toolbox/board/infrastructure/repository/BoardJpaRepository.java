package com.tools.toolbox.board.infrastructure.repository;

import com.tools.toolbox.board.core.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoardJpaRepository extends JpaRepository<Board, Long> {

    @Override
    @EntityGraph(attributePaths = {"author"})
    Optional<Board> findById(Long id);

    @EntityGraph(attributePaths = {"author"})
    Page<Board> findAllByCategoryId(Long category, Pageable pageable);
}
