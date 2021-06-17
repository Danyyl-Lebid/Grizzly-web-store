package com.github.grizzly.repository;

import com.github.grizzly.entity.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository {

    List<Review> findAllByProduct(long idProduct);

    List<Review> findAllByUserId(long idUser);

    Review createReview(Review review);

}
