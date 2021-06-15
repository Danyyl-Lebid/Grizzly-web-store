package com.github.grizzly.repository;

import com.github.grizzly.entity.SpecificationValue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpecificationValueRepository extends JpaRepository<SpecificationValue, Long> {

    Optional<SpecificationValue> findById(long id);

    List<SpecificationValue> findAllBySpecificationId(long specificationId);

    List<SpecificationValue> findAllByProductId(long productId);

}
