package com.v2.daechelinguide.domain.lunch.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "menu_lunch")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Lunch {

    @Id
    private String date;

    private String meal;

    private String mealDate;

    @Builder
    public Lunch(String meal, String date, String mealDate) {
        this.mealDate = mealDate;
        this.meal = meal;
        this.date = date;
    }
}
