package com.tools.toolbox.board.core;

import com.tools.toolbox.account.core.Account;
import com.tools.toolbox.board.core.command.BoardPostCmd;
import com.tools.toolbox.board.core.command.BoardPutCmd;
import com.tools.toolbox.board.core.enums.BoardStatus;
import com.tools.toolbox.boardcategory.core.BoardCategory;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Account author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category", nullable = false)
    private BoardCategory category;

    @Column(nullable = false)
    private String title;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    private int hit;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BoardStatus status;

    @Column(nullable = false)
    private String createdAt;

    @Column(nullable = false)
    private String updatedAt;

    @Builder
    public Board(Account author, BoardCategory boardCategory, BoardPostCmd boardPostCmd) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = format.format(new Date());
        this.author = author;
        this.category = boardCategory;
        this.title = boardPostCmd.getTitle();
        this.content = boardPostCmd.getContent();
        this.hit = 0;
        this.status = BoardStatus.VISIBLE;
        this.createdAt = date;
        this.updatedAt = date;
    }

    public boolean isOwned(String userId) {
        return this.author.getUserId().equals(userId);
    }

    public void setStatus(BoardStatus status){
        this.status = status;
    }

    public void modify(BoardPutCmd boardPutCmd) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        this.title = boardPutCmd.getTitle();
        this.content = boardPutCmd.getContent();
        this.updatedAt = format.format(new Date());
    }
}
