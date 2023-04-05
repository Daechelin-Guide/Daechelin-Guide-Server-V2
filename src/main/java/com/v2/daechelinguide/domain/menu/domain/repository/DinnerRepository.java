package com.v2.daechelinguide.domain.menu.domain.repository;

import com.v2.daechelinguide.domain.menu.domain.DinnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface DinnerRepository extends JpaRepository<DinnerEntity, Long> {
    @Query(value = "SELECT d.dinner FROM menu_dinner d where d.date = date", nativeQuery = true)
    String findDinnerByDate(String date);
}
