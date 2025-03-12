package com.tools.toolbox.board.core.command;

import com.tools.toolbox.account.core.Account;
import com.tools.toolbox.board.core.Board;
import com.tools.toolbox.boardcategory.core.BoardCategory;
import com.tools.toolbox.boardcategory.core.enums.CategoryType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardPostCmd {
    private String userId;
    private CategoryType category;
    private String title;
    private String content;

    public Board toEntity(Account author, BoardCategory boardCategory){
        return Board.builder()
                .author(author)
                .boardCategory(boardCategory)
                .boardPostCmd(this)
                .build();
    }

}
