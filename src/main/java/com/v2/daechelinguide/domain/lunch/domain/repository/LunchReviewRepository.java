package com.v2.daechelinguide.domain.lunch.domain.repository;

import com.v2.daechelinguide.domain.lunch.domain.LunchReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LunchReviewRepository extends JpaRepository<LunchReview, Long> {

    List<LunchReview> findAllByLunch_Date(String date);

    @Query(value = "select AVG(star) from review_lunch where lunch_date = :date", nativeQuery = true)
    double findByAvgStar(@Param("date") String date);
}
