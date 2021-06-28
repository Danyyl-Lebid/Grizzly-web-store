package com.github.grizzly.repository;

import com.github.grizzly.entity.Review;

import java.util.Date;

public class ReviewRepositoryMock {

    public static Review review1(){
        return new Review(1L,"the best product, im first",new Date(0),3,5);
    }

}
