package com.github.grizzly.controller.impl;

import com.github.grizzly.controller.ICategoryController;
import com.github.grizzly.dto.CategoryDto;
import com.github.grizzly.repository.CategoryRepository;
import com.github.grizzly.utils.CategoryTransferObject;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static com.github.grizzly.utils.CategoryTransferObject.toCategory;
import static com.github.grizzly.utils.CategoryTransferObject.fromCategory;

@RestController
@RequestMapping(path = "/category")
@RequiredArgsConstructor
@ApiImplicitParams(
        @ApiImplicitParam(
                name = "Authorization",
                value = "Access Token",
                required = true,
                paramType = "header",
                example = "Bearer access_token"
        )
)
public class CategoryController implements ICategoryController {

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> findAll() {
        return this.categoryRepository.findAll()
                .stream()
                .map(CategoryTransferObject::fromCategory)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto update(CategoryDto category) {
        return fromCategory(this.categoryRepository.save(toCategory(category)));
    }

    @Override
    public CategoryDto save(CategoryDto category) {
        return fromCategory(this.categoryRepository.save(toCategory(category)));
    }

    @Override
    public void deleteById(Long id) {
        this.categoryRepository.deleteById(id);
    }
}
