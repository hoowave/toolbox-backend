package com.tools.toolbox.review.infrastructure.adapter.out;

import com.tools.toolbox.review.application.port.out.ReviewRepositoryPort;
import com.tools.toolbox.review.core.Review;
import com.tools.toolbox.review.infrastructure.repository.ReviewJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryAdapter implements ReviewRepositoryPort {
    private final ReviewJpaRepository reviewRepository;

    @Override
    public Review save(Review review) {
        Review savedReview = reviewRepository.save(review);
        return savedReview;
    }

    @Override
    public Page<Review> findAll(Pageable pageable) {
        Page<Review> reviewList = reviewRepository.findAll(pageable);
        return reviewList;
    }
}
