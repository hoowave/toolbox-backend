package com.tools.toolbox.review.core.command;

import com.tools.toolbox.review.core.Review;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReviewPostCmd {
    private String author;
    private String content;
    private int star;

    public Review toEntity(){
        return Review.builder()
                .author(author)
                .content(content)
                .star(star)
                .build();
    }
}
