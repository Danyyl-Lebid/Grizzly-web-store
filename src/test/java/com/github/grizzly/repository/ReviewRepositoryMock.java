package com.github.grizzly.repository;

import com.github.grizzly.entity.Review;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class ReviewRepositoryMock {

    public static List<Review> products1(){
        return List.of(
                review1(),
                review4()
        );
    }

    public static List<Review> products2(){
        return List.of(
                review2(),
                review3()
        );
    }

    public static List<Review> products3(){
        return List.of(
                review5()
        );
    }

    public static List<Review> reviewer1(){
        return List.of(
                review1(),
                review2()
        );
    }

    public static List<Review> reviewer2(){
        return List.of(
                review3()
        );
    }

    public static List<Review> reviewer3(){
        return List.of(
                review4()
        );
    }

    public static List<Review> reviewer4(){
        return List.of(
                review5()
        );
    }


    public static Review review1() {
        Review review = new Review(1L,
                "the best product, im first",
                new Timestamp(0),
                3,
                5);
        review.setId(0);
        return review;
    }

    public static Review review2() {
        Review review = new Review(1L,
                "the best product2, im first",
                new Timestamp(0),
                2,
                4);
        review.setId(1);
        return review;
    }

    public static Review review3() {
        Review review = new Review(2L,
                "bad product, im hater",
                new Timestamp(0),
                2,
                1);
        review.setId(2);
        return review;
    }

    public static Review review4() {
        Review review = new Review(3L,
                "Im normal man, product normal",
                new Timestamp(0),
                3,
                3);
        review.setId(3);
        return review;
    }

    public static Review review5() {
        Review review = new Review(4L,
                "",
                new Timestamp(0),
                21,
                5);
        review.setId(4);
        return review;
    }
    
}
