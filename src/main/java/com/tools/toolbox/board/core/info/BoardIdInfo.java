package com.tools.toolbox.board.core.info;

import com.tools.toolbox.board.core.Board;
import lombok.Getter;

@Getter
public class BoardIdInfo {
    private Long id;

    public BoardIdInfo(Board board){
        this.id = board.getId();
    }
}
