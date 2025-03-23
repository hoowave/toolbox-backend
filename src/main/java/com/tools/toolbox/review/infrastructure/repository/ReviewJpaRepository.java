package com.tools.toolbox.review.infrastructure.repository;

import com.tools.toolbox.review.core.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewJpaRepository extends JpaRepository<Review, Long> {
}
