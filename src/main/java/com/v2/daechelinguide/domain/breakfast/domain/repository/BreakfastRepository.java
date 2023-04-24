package com.v2.daechelinguide.domain.breakfast.domain.repository;

import com.v2.daechelinguide.domain.breakfast.domain.Breakfast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BreakfastRepository extends JpaRepository<Breakfast, String> {
        Optional<Breakfast> findByDate(String date);
}
