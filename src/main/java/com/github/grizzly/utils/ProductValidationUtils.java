package com.github.grizzly.utils;

import java.util.regex.Pattern;

public class ProductValidationUtils {

    private static final String NAME_PRODUCT_PATTERN =
            "^[a-zA-Z0-9]{4,10}$";

    private static boolean isValidValue(String value, Pattern pattern) {
        return pattern.matcher(value).matches();
    }

    public static boolean isValidProductName(String name) {
        return isValidValue(name, Pattern.compile(NAME_PRODUCT_PATTERN));
    }

}
