package com.github.grizzly.validation.product;

import com.github.grizzly.annotations.ValidName;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProductNameValidator implements ConstraintValidator<ValidName, String> {

    @Override
    public void initialize(ValidName constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return ProductValidationUtils.isValidProductName(value);
    }
}
