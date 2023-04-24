package com.v2.daechelinguide.domain.lunch.service;

import com.v2.daechelinguide.domain.lunch.domain.Lunch;
import com.v2.daechelinguide.domain.lunch.domain.LunchRanking;
import com.v2.daechelinguide.domain.lunch.domain.LunchReview;
import com.v2.daechelinguide.domain.lunch.domain.repository.LunchRankingRepository;
import com.v2.daechelinguide.domain.lunch.domain.repository.LunchRepository;
import com.v2.daechelinguide.domain.lunch.domain.repository.LunchReviewRepository;
import com.v2.daechelinguide.domain.lunch.presentation.dto.request.LunchRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LunchService {

    private final LunchReviewRepository lunchReviewRepository;
    private final LunchRepository lunchRepository;
    private final LunchRankingRepository lunchRankingRepository;

    public void reviewToRankingCreate(String year, String month, String day, LunchRegisterRequest request) {
        String date = year.concat(month.concat(day));
        LunchReview lunchReview = request.toEntity();
        lunchReview.injectLunch(getLunch(date));

        lunchReviewRepository.save(lunchReview);
        rankingCreate(date);
    }

    public Page<LunchRanking> getRanking() {
        Pageable pageable = PageRequest.of(0, 10, Sort.Direction.DESC, "star");

        return lunchRankingRepository.findAll(pageable);
    }

    public void rankingCreate(String date) {
        LunchRanking ranking = LunchRanking.builder()
                .date(date)
                .star(getAvg(date))
                .build();

        ranking.injectLunch(getLunch(date));
        lunchRankingRepository.save(ranking);
    }

    public double getAvg(String date) {
        return lunchReviewRepository.findByAvgStar(date);
    }

    public List<LunchReview> getReview(String year, String month, String day) {
        String date = year.concat(month.concat(day));
        return lunchReviewRepository.findAllByLunch_Date(date);
    }

    public Lunch getLunch(String date) {
        return lunchRepository.findByDate(date)
                .orElseThrow(RuntimeException::new);
    }
}
