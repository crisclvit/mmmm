package com.harbor.samples.bookInfo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.harbor.samples.bookInfo.DTOUtils;
import com.harbor.samples.bookInfo.models.Review;
import com.harbor.samples.bookInfo.models.ReviewDTO;
import com.harbor.samples.bookInfo.services.ReviewService;

@RestController
public class ReviewController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReviewController.class);

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private DTOUtils dtoUtils;

    @PostMapping(value = "/review", consumes = "application/json", produces = "application/json")
    public ReviewDTO createReview(@RequestBody ReviewDTO reviewDto) {
        LOGGER.info("Creating review: {}", reviewDto);
        Review review = dtoUtils.convertToReview(reviewDto);
        LOGGER.info("Mapped review: {}", review);
        return dtoUtils.convertToReviewDTO(reviewService.createReview(review));
    }

    @GetMapping("/review/{id}")
    public ReviewDTO getReviewById(@PathVariable("id") Long id) {
        LOGGER.info("Getting review with id: {}", id);
        return dtoUtils.convertToReviewDTO(reviewService.getReviewById(id));
    }

    @PutMapping(value = "/review/{id}", consumes = "application/json", produces = "application/json")
    public ReviewDTO updateReview(@PathVariable("id") Long id, @RequestBody ReviewDTO reviewDto) {
        LOGGER.info("Updating review: {}", reviewDto);
        Review review = dtoUtils.convertToReview(reviewDto);
        return dtoUtils.convertToReviewDTO(reviewService.updateReview(review));
    }

    @DeleteMapping("/review/{id}")
    public void deleteReview(@PathVariable("id") Long id) {
        LOGGER.info("Deleting review with id: {}", id);
        reviewService.deleteReview(id);
    }

}
