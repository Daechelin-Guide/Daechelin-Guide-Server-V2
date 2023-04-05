package com.v2.daechelinguide.domain.menu.presentation;

import com.v2.daechelinguide.domain.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;



    @GetMapping("/{date}")
    public String findAll(@PathVariable String date) throws ParseException {
        return menuService.getMenu(date);
    }
}
