package com.tools.toolbox.review.application.service;

import com.tools.toolbox.review.application.port.in.ReviewPort;
import com.tools.toolbox.review.application.port.out.ReviewRepositoryPort;
import com.tools.toolbox.review.core.Review;
import com.tools.toolbox.review.core.command.ReviewGetCmd;
import com.tools.toolbox.review.core.command.ReviewPostCmd;
import com.tools.toolbox.review.core.info.ReviewIdInfo;
import com.tools.toolbox.review.core.info.ReviewListInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService implements ReviewPort {
    private final ReviewRepositoryPort reviewRepository;


    @Override
    public ReviewIdInfo create(ReviewPostCmd reviewPostCmd) {
        var initCmd = reviewPostCmd.toEntity();
        Review savedReview = reviewRepository.save(initCmd);
        var info = new ReviewIdInfo(savedReview);
        return info;
    }

    @Override
    public ReviewListInfo readList(ReviewGetCmd reviewGetCmd) {
        Pageable pageable = PageRequest.of(reviewGetCmd.getPage(), 5, Sort.by(Sort.Order.desc("createdAt")));
        Page<Review> reviewList = reviewRepository.findAll(pageable);
        var info = new ReviewListInfo(reviewList);
        return info;
    }
}
