package com.tools.toolbox.review.core;

import com.tools.toolbox.review.core.enums.ReviewStatus;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReviewStatus status;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private int star;

    @Column(nullable = false)
    private String createdAt;

    @Builder
    public Review(String author, String content, int star) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = format.format(new Date());
        this.status = ReviewStatus.VISIBLE;
        this.author = author;
        this.content = content;
        this.star = star;
        this.createdAt = date;
    }
}
