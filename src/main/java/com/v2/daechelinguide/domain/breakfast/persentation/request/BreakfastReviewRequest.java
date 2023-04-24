package com.v2.daechelinguide.domain.breakfast.persentation.request;

import com.v2.daechelinguide.domain.breakfast.domain.BreakfastReview;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BreakfastReviewRequest {

    private double star;

    private String message;

    public BreakfastReview toEntity() {
        return BreakfastReview.builder()
                .star(star)
                .message(message)
                .build();
    }
}
