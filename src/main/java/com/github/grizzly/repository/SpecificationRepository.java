package com.github.grizzly.repository;

import com.github.grizzly.entity.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpecificationRepository extends JpaRepository<Specification, Long> {

    Optional<Specification> findById(long id);

    List<Specification> findAllByCategoryId(long categoryId);

}
