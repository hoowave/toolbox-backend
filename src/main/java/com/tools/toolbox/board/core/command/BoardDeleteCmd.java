package com.tools.toolbox.board.core.command;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardDeleteCmd {
    private String userId;
    private Long id;
}
