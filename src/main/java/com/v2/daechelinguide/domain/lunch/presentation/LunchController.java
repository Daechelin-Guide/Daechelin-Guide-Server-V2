package com.v2.daechelinguide.domain.lunch.presentation;

import com.v2.daechelinguide.domain.lunch.domain.LunchRanking;
import com.v2.daechelinguide.domain.lunch.domain.LunchReview;
import com.v2.daechelinguide.domain.lunch.presentation.dto.request.LunchRegisterRequest;
import com.v2.daechelinguide.domain.lunch.service.LunchService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lunch")
@RequiredArgsConstructor
public class LunchController {
    private final LunchService lunchService;

    @PostMapping("/review/create")
    public void Create(@RequestParam String year,
                       @RequestParam String month,
                       @RequestParam String day,
                       @RequestBody LunchRegisterRequest request
    ) {
        lunchService.reviewToRankingCreate(year, month, day, request);
    }

    @GetMapping("/review")
    public List<LunchReview> getReview(@RequestParam String year,
                                       @RequestParam String month,
                                       @RequestParam String day) {
        return lunchService.getReview(year, month, day);
    }

    @GetMapping("/ranking")
    public Page<LunchRanking> getRankings(){
        return lunchService.getRanking();
    }
}
