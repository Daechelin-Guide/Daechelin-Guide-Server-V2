package com.v2.daechelinguide.domain.breakfast.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "menu_breakfast")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Breakfast {

    @Id
    private String date;

    private String breakfast;

    private String mealDate;

    @Builder
    public Breakfast(String breakfast, String date, String mealDate) {
        this.breakfast = breakfast;
        this.date = date;
        this.mealDate = mealDate;
    }
}
