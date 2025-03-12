package com.tools.toolbox.board.infrastructure.adapter.out;

import com.tools.toolbox.board.application.port.out.BoardRepositoryPort;
import com.tools.toolbox.board.core.Board;
import com.tools.toolbox.board.infrastructure.repository.BoardJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BoardRepositoryAdapter implements BoardRepositoryPort {
    private final BoardJpaRepository boardRepository;

    @Override
    public Board save(Board board) {
        Board savedBoard = boardRepository.save(board);
        return savedBoard;
    }

    @Override
    public Page<Board> findAllByCategoryId(Long category, Pageable pageable) {
        Page<Board> boardList = boardRepository.findAllByCategoryId(category, pageable);
        return boardList;
    }

    @Override
    public Optional<Board> findById(Long id) {
        Optional<Board> existBoard = boardRepository.findById(id);
        return existBoard;
    }

}
