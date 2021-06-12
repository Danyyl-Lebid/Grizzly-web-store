package com.github.grizzly.entity;

public class Category {

    private Long id;

    private String name;

    private String description;

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
