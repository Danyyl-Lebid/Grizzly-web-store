package com.github.grizzly.utils;

import com.github.grizzly.utils.annotations.ValidProductName;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProductNameValidator implements ConstraintValidator<ValidProductName, String> {

    @Override
    public void initialize(ValidProductName constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return ProductValidationUtils.isValidProductName(value);
    }
}
