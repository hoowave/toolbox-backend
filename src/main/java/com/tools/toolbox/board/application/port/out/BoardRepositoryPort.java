package com.tools.toolbox.board.application.port.out;

import com.tools.toolbox.board.core.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BoardRepositoryPort {

    Page<Board> findAllByCategoryId(Long category, Pageable pageable);

    Optional<Board> findById(Long id);

    Board save(Board board);

}
