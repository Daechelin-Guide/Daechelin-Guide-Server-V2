package com.v2.daechelinguide.domain.menu.domain.repository;

import com.v2.daechelinguide.domain.menu.domain.Menu;
import org.springframework.data.repository.CrudRepository;

public interface MenuRepository extends CrudRepository<Menu, String> {
    Menu findByDate(String date);
}
