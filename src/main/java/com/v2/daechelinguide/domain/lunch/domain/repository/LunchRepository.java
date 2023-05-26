package com.v2.daechelinguide.domain.lunch.domain.repository;

import com.v2.daechelinguide.domain.lunch.domain.Lunch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LunchRepository extends JpaRepository<Lunch, String> {
    Optional<Lunch> findByDate(String date);
    Lunch findLunchByDate(String date);

}
