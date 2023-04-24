package com.v2.daechelinguide.domain.dinner.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "menu_dinner")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Dinner {

    @Id
    private String date;

    private String dinner;

    private String mealDate;

    @Builder
    public Dinner(String date, String dinner, String mealDate) {
        this.date = date;
        this.dinner = dinner;
        this.mealDate = mealDate;
    }
}
