package com.v2.daechelinguide.domain.menu.domain.repository;

import com.v2.daechelinguide.domain.menu.domain.BreakfastEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface BreakfastRepository extends JpaRepository<BreakfastEntity, Long> {
    @Query(value = "SELECT b.breakfast FROM menu_breakfast b where b.date = date", nativeQuery = true)
    String findBreakfastByDate(String date);
}
