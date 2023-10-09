package com.harbor.samples.bookInfo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.harbor.samples.bookInfo.models.Review;

@Service
public interface ReviewRepo extends CrudRepository<Review, Long> {
}
