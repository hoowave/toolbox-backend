package com.tools.toolbox.review.core.info;

import com.tools.toolbox.review.core.Review;
import lombok.Getter;

@Getter
public class ReviewIdInfo {
    private Long id;

    public ReviewIdInfo(Review review) {
        this.id = review.getId();
    }
}
