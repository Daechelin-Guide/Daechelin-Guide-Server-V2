package com.v2.daechelinguide.domain.breakfast.persentation.dto.response;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewResponse {
    private double star;
    private String message;
}
