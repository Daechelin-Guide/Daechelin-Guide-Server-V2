package com.v2.daechelinguide.domain.dinner.presentation;

import com.v2.daechelinguide.domain.dinner.domain.DinnerRanking;
import com.v2.daechelinguide.domain.dinner.domain.DinnerReview;
import com.v2.daechelinguide.domain.dinner.presentation.dto.request.DinnerRegisterRequest;
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
    public void Create(@RequestParam String date,
                       @RequestBody DinnerRegisterRequest request
    ) {
        dinnerService.reviewToRankingCreate(date, request);
    }

    @GetMapping("/review")
    public List<DinnerReview> getReview(@RequestParam String date) {
        return dinnerService.getReview(date);
    }

    @GetMapping("/ranking")
    public Page<DinnerRanking> getRankings(){
        return dinnerService.getRanking();
    }
}
