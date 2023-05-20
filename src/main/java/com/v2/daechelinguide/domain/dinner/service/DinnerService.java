package com.v2.daechelinguide.domain.dinner.service;

import com.v2.daechelinguide.domain.dinner.domain.Dinner;
import com.v2.daechelinguide.domain.dinner.domain.DinnerRanking;
import com.v2.daechelinguide.domain.dinner.domain.DinnerReview;
import com.v2.daechelinguide.domain.dinner.domain.repository.DinnerRankingRepository;
import com.v2.daechelinguide.domain.dinner.domain.repository.DinnerRepository;
import com.v2.daechelinguide.domain.dinner.domain.repository.DinnerReviewRepository;
import com.v2.daechelinguide.domain.dinner.presentation.dto.request.DinnerRegisterRequest;
import com.v2.daechelinguide.domain.dinner.presentation.dto.response.RankingListResponse;
import com.v2.daechelinguide.domain.dinner.presentation.dto.response.ReviewListResponse;
import com.v2.daechelinguide.global.exception.global.MealNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DinnerService {

    private final DinnerReviewRepository dinnerReviewRepository;
    private final DinnerRepository dinnerRepository;
    private final DinnerRankingRepository dinnerRankingRepository;

    public void reviewToRankingCreate(String date, DinnerRegisterRequest request) {
        DinnerReview dinnerReview = request.toEntity();
        dinnerReview.injectDinner(getDinner(date));

        dinnerReviewRepository.save(dinnerReview);
        rankingCreate(date);
    }

    public RankingListResponse getRanking() {
        Pageable pageable = PageRequest.of(0, 10, Sort.Direction.DESC, "star");

        Page<DinnerRanking> ranking = dinnerRankingRepository.findAll(pageable);

        return RankingListResponse.builder()
                .response(ranking.getContent())
                .build();
    }

    public void rankingCreate(String date) {
        DinnerRanking ranking = DinnerRanking.builder()
                .date(date)
                .star(getAvg(date))
                .build();

        ranking.injectDinner(getDinner(date));
        dinnerRankingRepository.save(ranking);
    }

    public double getAvg(String date) {
        return dinnerReviewRepository.findByAvgStar(date);
    }

    public ReviewListResponse getReview(String date) {
        List<DinnerReview> review = dinnerReviewRepository.findAllByDinner_Date(date);

        return ReviewListResponse.builder()
                .totalStar(getAvg(date))
                .response(review)
                .build();
    }

    public Dinner getDinner(String date) {
        return dinnerRepository.findByDate(date)
                .orElseThrow(() -> MealNotFoundException.EXCEPTION);
    }
}
