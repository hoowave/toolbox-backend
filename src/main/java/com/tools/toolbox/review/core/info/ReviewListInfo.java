package com.tools.toolbox.review.core.info;

import com.tools.toolbox.review.core.Review;
import com.tools.toolbox.review.core.enums.ReviewStatus;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ReviewListInfo {

    @Getter
    public static class ReviewInfo {
        private Long id;
        private ReviewStatus status;
        private String author;
        private String content;
        private int star;
        private String createdAt;

        public ReviewInfo(Review review) {
            this.id = review.getId();
            this.status = review.getStatus();
            this.author = review.getAuthor();
            this.content = review.getContent();
            this.star = review.getStar();
            this.createdAt = review.getCreatedAt();
        }
    }

    private List<ReviewInfo> contents;
    private int pageNumber;
    private int totalPageNumber;
    private Long totalNumber;
    private boolean isFirst;
    private boolean isLast;
    private boolean isEmpty;

    public ReviewListInfo(Page<Review> reviewList) {
        this.contents = reviewList.stream()
                .map(ReviewInfo::new)
                .collect(Collectors.toList());
        this.pageNumber = reviewList.getNumber();
        this.totalPageNumber = reviewList.getTotalPages();
        this.totalNumber = reviewList.getTotalElements();
        this.isFirst = reviewList.isFirst();
        this.isLast = reviewList.isLast();
        this.isEmpty = reviewList.isEmpty();
    }

}
