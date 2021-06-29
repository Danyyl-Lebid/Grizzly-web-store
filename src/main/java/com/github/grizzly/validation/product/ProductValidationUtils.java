package com.github.grizzly.validation.product;

import java.util.regex.Pattern;

public class ProductValidationUtils {

    private static final String NAME_PRODUCT_PATTERN =
            "^[A-Za-z\\x{00C0}-\\x{00FF}][A-Za-z\\x{00C0}-\\x{00FF}\\'\\-]+([\\ A-Za-z\\x{00C0}-\\x{00FF}][A-Za-z\\x{00C0}-\\x{00FF}\\'\\-]+)*/u";

    private static boolean isValidValue(String value, Pattern pattern) {
        return pattern.matcher(value).matches();
    }

    public static boolean isValidProductName(String name) {
        return isValidValue(name, Pattern.compile(NAME_PRODUCT_PATTERN));
    }

}
