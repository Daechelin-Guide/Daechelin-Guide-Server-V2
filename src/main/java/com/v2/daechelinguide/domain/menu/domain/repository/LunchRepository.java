package com.v2.daechelinguide.domain.menu.domain.repository;

import com.v2.daechelinguide.domain.menu.domain.LunchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface LunchRepository extends JpaRepository<LunchEntity, Long> {
    @Query(value = "SELECT l.lunch FROM menu_lunch l where l.date = date", nativeQuery = true)
    String findLunchByDate(String date);
}
