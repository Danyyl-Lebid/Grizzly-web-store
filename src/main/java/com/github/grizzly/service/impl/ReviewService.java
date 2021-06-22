package com.github.grizzly.service.impl;

import com.github.grizzly.entity.Review;
import com.github.grizzly.repository.ReviewRepository;
import com.github.grizzly.service.IReviewService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ReviewService implements IReviewService {

    private final ReviewRepository reviewRepository;

    @Override
    public List<Review> findAllByProduct(Long idProduct) {
        return reviewRepository.findAllByProduct(idProduct);
    }

    @Override
    public List<Review> findAllByUserId(Long idUser) {
        return reviewRepository.findAllByUserId(idUser);
    }

    @Override
    public void save(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public Review update(Review review) {
        return reviewRepository.save(review);
    }
}
