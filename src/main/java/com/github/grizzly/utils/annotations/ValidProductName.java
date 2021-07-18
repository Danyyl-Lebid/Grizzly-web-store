package com.github.grizzly.utils.annotations;

import javax.validation.Payload;

public @interface ValidProductName {

    String message() default "Invalid Product Name";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
