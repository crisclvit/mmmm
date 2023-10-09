package com.harbor.samples.bookInfo.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harbor.samples.bookInfo.models.Review;
import com.harbor.samples.bookInfo.repositories.ReviewRepo;

@Service
public class ReviewService {
    public static final Logger LOGGER = LoggerFactory.getLogger(ReviewService.class);

    @Autowired
    private ReviewRepo reviewRepo;

    public Review createReview(Review review) {
        LOGGER.info("Creating review: {}", review);
        return reviewRepo.save(review);
    }

    public Review getReviewById(Long id) {
        LOGGER.info("Getting review with id: {}", id);
        return reviewRepo.findById(id).orElse(null);
    }

    public Review updateReview(Review review) {
        LOGGER.info("Updating review: {}", review);
        return reviewRepo.save(review);
    }

    public void deleteReview(Long id) {
        LOGGER.info("Deleting review with id: {}", id);
        reviewRepo.deleteById(id);
    }
}
