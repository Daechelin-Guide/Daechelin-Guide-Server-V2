package com.v2.daechelinguide.domain.menu.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "menu_breakfast")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BreakfastEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String breakfast;

    private String date;
}
