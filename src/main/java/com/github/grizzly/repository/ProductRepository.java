package com.github.grizzly.repository;

import com.github.grizzly.entity.ActiveState;
import com.github.grizzly.entity.Product;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByName(@NonNull String name);

    List<Product> findAllByCategoryId(Long categoryId);

    List<Product> findAllByCategoryName(String name);

    List<Product> findProductsByState(ActiveState activeState);

    @Modifying
    @Query(value = "update Product p set p.state = :activeState where p.id = :id")
    void updateState(@Param(value = "id") Long id, @Param(value = "activeState") ActiveState state);

}
