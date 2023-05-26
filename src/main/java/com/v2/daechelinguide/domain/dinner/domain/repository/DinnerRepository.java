package com.v2.daechelinguide.domain.dinner.domain.repository;

import com.v2.daechelinguide.domain.dinner.domain.Dinner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DinnerRepository extends JpaRepository<Dinner, String> {
    Optional<Dinner> findByDate(String date);
    Dinner findDinnerByDate(String date);

}
