package com.github.grizzly.repository;

import com.github.grizzly.entity.Category;

import java.util.List;

public class CategoryRepositoryMock {

    public static List<Category> categories(){
        return List.of(
                category1(),
                category2(),
                category3(),
                category4()
        );
    }

    public static Category category1() {
        return new Category(
                1L,
                null,
                "Phone",
                "Phone description"
                );
    }

    public static Category category2() {
        return new Category(
                2,
                null,
                "Computers",
                "description to computer"
        );
    }

    public static Category category3() {
        return new Category(
                3L,
                1L,
                "SmartPhone",
                "SmartPhones description"
        );
    }

    public static Category category4() {
        return new Category(
                4,
                null,
                "Food",
                "Nyam-nyam"
        );
    }


}
