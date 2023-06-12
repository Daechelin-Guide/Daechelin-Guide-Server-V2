package com.v2.daechelinguide.domain.menu.presentation;

import com.v2.daechelinguide.domain.menu.presentation.dto.response.MenuResponse;
import com.v2.daechelinguide.domain.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;

    @GetMapping
    public MenuResponse findAll(
            @RequestParam String year,
            @RequestParam String month,
            @RequestParam String day) {
        return menuService.getMeal(year, month, day);
    }

}
