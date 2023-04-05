package com.v2.daechelinguide.domain.menu.service;

import com.v2.daechelinguide.domain.menu.domain.repository.BreakfastRepository;
import com.v2.daechelinguide.domain.menu.domain.repository.DinnerRepository;
import com.v2.daechelinguide.domain.menu.domain.repository.LunchRepository;
import com.v2.daechelinguide.domain.menu.presentation.dto.response.MenuResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final BreakfastRepository breakfastRepository;
    private final LunchRepository lunchRepository;
    private final DinnerRepository dinnerRepository;

    @Transactional
    public MenuResponseDto findAll(String date) {

        String breakfast = breakfastRepository.findBreakfastByDate(date);
        String dinner = dinnerRepository.findDinnerByDate(date);
        String lunch = lunchRepository.findLunchByDate(date);

        return new MenuResponseDto(breakfast, dinner, lunch);
    }
}
