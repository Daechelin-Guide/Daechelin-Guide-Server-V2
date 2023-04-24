package com.v2.daechelinguide.domain.breakfast.domain.repository;

import com.v2.daechelinguide.domain.breakfast.domain.BreakfastReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BreakfastReviewRepository extends JpaRepository<BreakfastReview, Long> {
    List<BreakfastReview> findAllByBreakfast_Date(String date);

    @Query(value = "select AVG(star) from review_breakfast where breakfast_date = :date", nativeQuery = true)
    double findByAvgStar(@Param("date") String date);
}
