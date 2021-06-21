package com.github.grizzly.validation.user;

import com.github.grizzly.annotations.ValidLogin;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginValidator implements ConstraintValidator<ValidLogin, String> {

    private static final String LOGIN_PATTERN =
            "^(?=.*[A-Za-z0-9]$)[A-Za-z][A-Za-z\\d.-]{0,19}$";

    @Override
    public void initialize(ValidLogin constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return validateLogin(value);
    }

    private boolean validateLogin(String login) {
        Pattern pattern = Pattern.compile(LOGIN_PATTERN);
        Matcher matcher = pattern.matcher(login);
        return matcher.matches();
    }
}
