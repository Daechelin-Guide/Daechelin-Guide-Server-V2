package com.v2.daechelinguide.domain.lunch.presentation;

import com.v2.daechelinguide.domain.lunch.presentation.dto.request.LunchRegisterRequest;
import com.v2.daechelinguide.domain.lunch.presentation.dto.response.RankingListResponse;
import com.v2.daechelinguide.domain.lunch.presentation.dto.response.ReviewListResponse;
import com.v2.daechelinguide.domain.lunch.service.LunchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lunch")
@RequiredArgsConstructor
public class LunchController {
    private final LunchService lunchService;

    @PostMapping("/review/create")
    public void Create(@RequestParam String date,
                       @RequestBody LunchRegisterRequest request
    ) {
        lunchService.reviewToRankingCreate(date, request);
    }

    @GetMapping("/review")
    public ReviewListResponse getReview(@RequestParam String date) {
        return lunchService.getReview(date);
    }

    @GetMapping("/ranking")
    public RankingListResponse getRankings(){
        return lunchService.getRanking();
    }
}
