package com.v2.daechelinguide.domain.lunch.presentation.dto.response;

import com.v2.daechelinguide.domain.dinner.domain.DinnerRanking;
import com.v2.daechelinguide.domain.lunch.domain.LunchRanking;
import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RankingListResponse {
    List<LunchRanking> response;
}
