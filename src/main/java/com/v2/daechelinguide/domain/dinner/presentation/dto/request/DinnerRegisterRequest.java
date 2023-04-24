package com.v2.daechelinguide.domain.dinner.presentation.dto.request;

import com.v2.daechelinguide.domain.dinner.domain.DinnerReview;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DinnerRegisterRequest {
    private double star;

    private String message;

    public DinnerReview toEntity() {
        return DinnerReview.builder()
                .star(star)
                .message(message)
                .build();
    }
}
