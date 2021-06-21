package com.github.grizzly.validation.user;

import com.github.grizzly.annotations.ValidName;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameValidator implements ConstraintValidator<ValidName, String> {

    private static final String NAME_PATTERN =
            "^[A-Za-z\\x{00C0}-\\x{00FF}][A-Za-z\\x{00C0}-\\x{00FF}\\'\\-]+([\\ A-Za-z\\x{00C0}-\\x{00FF}][A-Za-z\\x{00C0}-\\x{00FF}\\'\\-]+)*/u";

    @Override
    public void initialize(ValidName constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return validateName(value);
    }

    private boolean validateName(String name) {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

}
