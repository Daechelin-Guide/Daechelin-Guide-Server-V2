package com.v2.daechelinguide.domain.dinner.presentation;

import com.v2.daechelinguide.domain.dinner.domain.DinnerRanking;
import com.v2.daechelinguide.domain.dinner.presentation.dto.request.DinnerRegisterRequest;
import com.v2.daechelinguide.domain.dinner.presentation.dto.response.RankingListResponse;
import com.v2.daechelinguide.domain.dinner.presentation.dto.response.ReviewListResponse;
import com.v2.daechelinguide.domain.dinner.service.DinnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dinner")
@RequiredArgsConstructor
public class DinnerController {
    private final DinnerService dinnerService;

    @PostMapping("/review/create")
    public void Create(@RequestParam String date,
                       @RequestBody DinnerRegisterRequest request
    ) {
        dinnerService.reviewToRankingCreate(date, request);
    }

    @GetMapping("/review")
    public ReviewListResponse getReview(@RequestParam String date) {
        return dinnerService.getReview(date);
    }

    @GetMapping("/ranking")
    public RankingListResponse getRankings(){
        return dinnerService.getRanking();
    }
}
