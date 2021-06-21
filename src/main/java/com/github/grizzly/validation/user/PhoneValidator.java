package com.github.grizzly.validation.user;

import com.github.grizzly.annotations.ValidPhone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidator implements ConstraintValidator<ValidPhone, String> {

    private static final String PHONE_PATTERN =
            "/\\(?([0-9]{3})\\)?([ .-]?)([0-9]{3})\\2([0-9]{4})/";

    @Override
    public void initialize(ValidPhone constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return validatePhone(value);
    }

    private boolean validatePhone(String phone) {
        Pattern pattern = Pattern.compile(PHONE_PATTERN);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }
}
