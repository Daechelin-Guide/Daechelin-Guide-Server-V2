package com.v2.daechelinguide.domain.dinner.presentation.dto.response;

import com.v2.daechelinguide.domain.dinner.domain.DinnerRanking;
import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RankingListResponse {
    List<DinnerRanking> response;
}
