package com.tools.toolbox.board.application.port.in;

import com.tools.toolbox.board.core.command.BoardDetailsCmd;
import com.tools.toolbox.board.core.command.BoardListCmd;
import com.tools.toolbox.board.core.command.BoardPostCmd;
import com.tools.toolbox.board.core.info.BoardDetailsInfo;
import com.tools.toolbox.board.core.info.BoardListInfo;
import com.tools.toolbox.board.core.info.BoardPostInfo;

public interface BoardPort {
    BoardListInfo readList(BoardListCmd boardListCmd);

    BoardDetailsInfo readDetails(BoardDetailsCmd boardDetailsCmd);

    BoardPostInfo create(BoardPostCmd boardPostCmd);
}
