package com.tools.toolbox.board.core.command;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardPutCmd {
    private String userId;
    private Long id;
    private String title;
    private String content;
}
