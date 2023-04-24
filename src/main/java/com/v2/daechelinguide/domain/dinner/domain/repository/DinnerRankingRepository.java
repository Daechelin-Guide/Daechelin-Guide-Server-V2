package com.v2.daechelinguide.domain.dinner.domain.repository;

import com.v2.daechelinguide.domain.dinner.domain.DinnerRanking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DinnerRankingRepository extends JpaRepository<DinnerRanking, String> {
}
