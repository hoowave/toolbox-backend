package com.tools.toolbox.board.core;

import com.tools.toolbox.account.core.Account;
import com.tools.toolbox.board.core.enums.BoardStatus;
import com.tools.toolbox.boardcategory.core.BoardCategory;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category", nullable = false)
    private BoardCategory category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Account author;

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
}
