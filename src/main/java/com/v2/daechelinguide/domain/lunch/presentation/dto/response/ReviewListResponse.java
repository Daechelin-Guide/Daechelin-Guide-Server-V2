package com.v2.daechelinguide.domain.lunch.presentation.dto.response;

import com.v2.daechelinguide.domain.lunch.domain.LunchReview;
import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewListResponse {
    private double totalStar;
    private List<LunchReview> response;
}