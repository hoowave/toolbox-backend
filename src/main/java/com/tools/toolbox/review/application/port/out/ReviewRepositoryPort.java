package com.tools.toolbox.review.application.port.out;

import com.tools.toolbox.review.core.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReviewRepositoryPort {
    Review save(Review review);

    Page<Review> findAll(Pageable pageable);
}