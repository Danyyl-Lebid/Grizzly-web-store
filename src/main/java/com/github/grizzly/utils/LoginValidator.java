package com.github.grizzly.utils;

import com.github.grizzly.utils.annotations.ValidLogin;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LoginValidator implements ConstraintValidator<ValidLogin, String> {

    @Override
    public void initialize(ValidLogin constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return UserValidationUtils.isValidLogin(value);
    }

}
