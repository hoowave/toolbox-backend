package com.tools.toolbox.board.core.command;

import com.tools.toolbox.boardcategory.core.enums.CategoryType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardListCmd {
    private int page;
    private CategoryType categoryType;
}
