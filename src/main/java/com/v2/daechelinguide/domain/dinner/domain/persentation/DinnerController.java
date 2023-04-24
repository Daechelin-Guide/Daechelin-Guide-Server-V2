package com.v2.daechelinguide.domain.dinner.domain.persentation;

import com.v2.daechelinguide.domain.dinner.domain.DinnerRanking;
import com.v2.daechelinguide.domain.dinner.domain.DinnerReview;
import com.v2.daechelinguide.domain.dinner.domain.persentation.dto.request.DinnerReviewRequest;
import com.v2.daechelinguide.domain.dinner.service.DinnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dinner")
@RequiredArgsConstructor
public class DinnerController {

    private final DinnerService dinnerService;

    @PostMapping("/review/create")
    public void Create(@RequestParam String year,
                       @RequestParam String month,
                       @RequestParam String day,
                       @RequestBody DinnerReviewRequest request
    ) {
        dinnerService.reviewToRankingCreate(year, month, day, request);
    }

    @GetMapping("/review")
    public List<DinnerReview> getReview(@RequestParam String year,
                                        @RequestParam String month,
                                        @RequestParam String day) {
        return dinnerService.getReview(year, month, day);
    }

    @GetMapping("/ranking")
    public Page<DinnerRanking> getRankings(){
        return dinnerService.getRanking();
    }

}