package com.v2.daechelinguide.domain.dinner.service;

import com.v2.daechelinguide.domain.dinner.domain.Dinner;
import com.v2.daechelinguide.domain.dinner.domain.DinnerRanking;
import com.v2.daechelinguide.domain.dinner.domain.DinnerReview;
import com.v2.daechelinguide.domain.dinner.domain.persentation.dto.request.DinnerReviewRequest;
import com.v2.daechelinguide.domain.dinner.domain.repository.DinnerRankingRepository;
import com.v2.daechelinguide.domain.dinner.domain.repository.DinnerRepository;
import com.v2.daechelinguide.domain.dinner.domain.repository.DinnerReviewRepository;
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

    public void reviewToRankingCreate(String year, String month, String day, DinnerReviewRequest request) {
        String date = year.concat(month.concat(day));
        DinnerReview dinnerReview = request.toEntity();
        dinnerReview.injectDinner(getDinner(date));

        dinnerReviewRepository.save(dinnerReview);
        rankingCreate(date);
    }

    public Page<DinnerRanking> getRanking() {
        Pageable pageable = PageRequest.of(0, 10, Sort.Direction.DESC, "star");

        return dinnerRankingRepository.findAll(pageable);
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

    public List<DinnerReview> getReview(String year, String month, String day) {
        String date = year.concat(month.concat(day));
        return dinnerReviewRepository.findAllByDinner_Date(date);
    }

    public Dinner getDinner(String date) {
        return dinnerRepository.findByDate(date)
                .orElseThrow(RuntimeException::new);
    }
}
