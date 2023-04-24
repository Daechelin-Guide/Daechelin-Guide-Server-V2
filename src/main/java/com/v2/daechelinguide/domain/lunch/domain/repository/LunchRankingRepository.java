package com.v2.daechelinguide.domain.lunch.domain.repository;

import com.v2.daechelinguide.domain.lunch.domain.LunchRanking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LunchRankingRepository extends JpaRepository<LunchRanking, String> {
}
