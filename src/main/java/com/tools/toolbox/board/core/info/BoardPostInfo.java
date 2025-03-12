package com.tools.toolbox.board.core.info;

import com.tools.toolbox.board.core.Board;
import lombok.Getter;

@Getter
public class BoardPostInfo {
    private Long id;

    public BoardPostInfo(Board board){
        this.id = board.getId();
    }
}
