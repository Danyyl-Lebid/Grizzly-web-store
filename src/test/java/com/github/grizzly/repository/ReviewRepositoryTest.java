package com.github.grizzly.repository;

import com.github.grizzly.entity.Review;
import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

@DataJpaTest
@RunWith(SpringRunner.class)
@ActiveProfiles(value = "test")
public class ReviewRepositoryTest {

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    @Sql({"grizzly-review-schema.sql","grizzly-review-data.sql"})
    public void findFirst(){
        List<Review> act = this.reviewRepository.findAllByIdReviewer(1L);
        List<Review> exp = ReviewRepositoryMock.reviewer1();
        Assert.assertThat(exp, containsInAnyOrder(act.toArray()));
    }

    @Test
    @Sql({"grizzly-review-schema.sql","grizzly-review-data.sql"})
    public void findProduct(){
        List<Review> act = this.reviewRepository.findAllByProductId(3L);
        List<Review> exp = ReviewRepositoryMock.products1();
        Assert.assertThat(exp, containsInAnyOrder(act.toArray()));
    }

}


