package com.tools.toolbox.board.core.info;

import com.tools.toolbox.board.core.Board;
import com.tools.toolbox.board.core.enums.BoardStatus;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class BoardListInfo {

    @Getter
    public static class BoardInfo{
        private String author;
        private String title;
        private int hit;
        private BoardStatus status;
        private String createdAt;

        public BoardInfo(Board board) {
            this.author = board.getAuthor().getUserId();
            this.title = board.getTitle();
            this.hit = board.getHit();
            this.status = board.getStatus();
            this.createdAt = board.getCreatedAt();
        }
    }

    private List<BoardInfo> contents;
    private int pageNumber;
    private int totalPageNumber;
    private boolean isFirst;
    private boolean isLast;
    private boolean isEmpty;

    public BoardListInfo(Page<Board> boardList) {
        this.contents = boardList.stream()
                .map(BoardInfo::new)
                .collect(Collectors.toList());
        this.pageNumber = boardList.getNumber();
        this.totalPageNumber = boardList.getTotalPages() - 1;
        this.isFirst = boardList.isFirst();
        this.isLast = boardList.isLast();
        this.isEmpty = boardList.isEmpty();
    }
}
