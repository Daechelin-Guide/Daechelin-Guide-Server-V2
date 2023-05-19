package com.v2.daechelinguide.domain.dinner.presentation.dto.response;

import com.v2.daechelinguide.domain.dinner.domain.DinnerReview;
import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewListResponse {
    private double totalStar;
    private List<DinnerReview> response;
}