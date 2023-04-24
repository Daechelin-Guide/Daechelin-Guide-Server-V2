package com.v2.daechelinguide.domain.breakfast.persentation;

import com.v2.daechelinguide.domain.breakfast.domain.BreakfastRanking;
import com.v2.daechelinguide.domain.breakfast.domain.BreakfastReview;
import com.v2.daechelinguide.domain.breakfast.persentation.request.BreakfastReviewRequest;
import com.v2.daechelinguide.domain.breakfast.service.BreakfastService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/breakfast")
@RequiredArgsConstructor
public class BreakfastController {
    private final BreakfastService breakfastService;

    @PostMapping("/review/create")
    public void Create(@RequestParam String year,
                       @RequestParam String month,
                       @RequestParam String day,
                       @RequestBody BreakfastReviewRequest request
                       ) {
        breakfastService.reviewToRankingCreate(year, month, day, request);
    }

    @GetMapping("/review")
    public List<BreakfastReview> getReview(@RequestParam String year,
                                           @RequestParam String month,
                                           @RequestParam String day) {
        return breakfastService.getReview(year, month, day);
    }

    @GetMapping("/ranking")
    public Page<BreakfastRanking> getRankings(){
        return breakfastService.getRanking();
    }
}