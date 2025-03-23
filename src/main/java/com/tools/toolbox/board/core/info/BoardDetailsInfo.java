package com.tools.toolbox.board.core.info;

import com.tools.toolbox.board.core.Board;
import com.tools.toolbox.board.core.enums.BoardStatus;
import lombok.Getter;

@Getter
public class BoardDetailsInfo {
    private Long id;
    private String author;
    private String title;
    private String content;
    private int hit;
    private BoardStatus status;
    private String createdAt;

    public BoardDetailsInfo(Board board) {
        this.id = board.getId();
        this.author = board.getAuthor().getUserId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.hit = board.getHit();
        this.status = board.getStatus();
        this.createdAt = board.getCreatedAt();
    }
}
