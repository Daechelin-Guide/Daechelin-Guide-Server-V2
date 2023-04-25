package com.v2.daechelinguide.global.exception.global;

import com.v2.daechelinguide.global.exception.CustomException;
import org.springframework.http.HttpStatus;

public class MealNotFoundException extends CustomException {
    public static final CustomException EXCEPTION = new MealNotFoundException();

    private MealNotFoundException() {
        super(HttpStatus.NOT_FOUND, "해당 날짜의 급식이 없습니다.");
    }
}
