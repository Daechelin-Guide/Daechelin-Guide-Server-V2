package com.v2.daechelinguide.domain.breakfast.persentation.dto.response;

import com.v2.daechelinguide.domain.breakfast.domain.BreakfastReview;
import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewListResponse {
    private double totalStar;
    private List<BreakfastReview> response;
}
