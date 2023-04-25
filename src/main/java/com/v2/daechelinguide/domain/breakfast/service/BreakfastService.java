package com.v2.daechelinguide.domain.breakfast.service;

import com.v2.daechelinguide.domain.breakfast.domain.Breakfast;
import com.v2.daechelinguide.domain.breakfast.domain.BreakfastRanking;
import com.v2.daechelinguide.domain.breakfast.domain.BreakfastReview;
import com.v2.daechelinguide.domain.breakfast.domain.repository.BreakfastRankingRepository;
import com.v2.daechelinguide.domain.breakfast.domain.repository.BreakfastRepository;
import com.v2.daechelinguide.domain.breakfast.domain.repository.BreakfastReviewRepository;
import com.v2.daechelinguide.global.exception.global.MealNotFoundException;
import com.v2.daechelinguide.domain.breakfast.persentation.dto.request.BreakfastReviewRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BreakfastService {

    private final BreakfastReviewRepository breakfastReviewRepository;
    private final BreakfastRepository breakfastRepository;
    private final BreakfastRankingRepository breakfastRankingRepository;

    public void reviewToRankingCreate(String date, BreakfastReviewRequest request) {
        BreakfastReview breakfastReview = request.toEntity();
        breakfastReview.injectBreakfast(getBreakfast(date));

        breakfastReviewRepository.save(breakfastReview);
        rankingCreate(date);
    }

    public Page<BreakfastRanking> getRanking() {
        Pageable pageable = PageRequest.of(0, 10, Sort.Direction.DESC, "star");

        return breakfastRankingRepository.findAll(pageable);
    }

    public void rankingCreate(String date) {
        BreakfastRanking ranking = BreakfastRanking.builder()
                .date(date)
                .star(getAvg(date))
                .build();

        ranking.injectBreakfast(getBreakfast(date));
        breakfastRankingRepository.save(ranking);
    }

    public double getAvg(String date) {
        return breakfastReviewRepository.findByAvgStar(date);
    }

    public List<BreakfastReview> getAllReview(String date) {
        return breakfastReviewRepository.findAllByBreakfast_Date(date);
    }

    public Breakfast getBreakfast(String date) {
        return breakfastRepository.findByDate(date)
                .orElseThrow(() -> MealNotFoundException.EXCEPTION);
    }
}
