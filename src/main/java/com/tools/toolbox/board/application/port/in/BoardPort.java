package com.tools.toolbox.board.application.port.in;

import com.tools.toolbox.account.core.Account;
import com.tools.toolbox.board.core.command.*;
import com.tools.toolbox.board.core.info.BoardDetailsInfo;
import com.tools.toolbox.board.core.info.BoardListInfo;
import com.tools.toolbox.board.core.info.BoardIdInfo;
import com.tools.toolbox.boardcategory.core.enums.CategoryType;

public interface BoardPort {
    BoardListInfo readList(BoardListCmd boardListCmd);

    BoardDetailsInfo readDetails(BoardDetailsCmd boardDetailsCmd);

    BoardIdInfo create(BoardPostCmd boardPostCmd);

    BoardIdInfo modify(BoardPutCmd boardPutCmd);

    BoardIdInfo delete(BoardDeleteCmd boardDeleteCmd);

    void validateNoticePermission(CategoryType category, Account author);
}
