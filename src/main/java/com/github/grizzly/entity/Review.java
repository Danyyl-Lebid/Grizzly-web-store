package com.github.grizzly.entity;

import lombok.AccessLevel;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Review {

    @Id
    @Setter(value= AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_id", nullable = false)
    private long idReviewer;

    @Column(name = "review", columnDefinition = "VARCHAR(256)")
    private String review;

    @Column(name = "created_date", nullable = false)
    private Date createdAt;

    @Column(name = "name", nullable = false)
    private int rate;

}
