package com.tools.toolbox.board.infrastructure.adapter.out;

import com.tools.toolbox.board.application.port.out.BoardRepositoryPort;
import com.tools.toolbox.board.core.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BoardRepositoryAdapter implements BoardRepositoryPort {

    @Override
    public void save(Board board) {

    }

}
