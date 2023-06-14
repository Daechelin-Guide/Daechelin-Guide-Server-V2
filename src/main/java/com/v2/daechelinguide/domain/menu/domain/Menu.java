package com.v2.daechelinguide.domain.menu.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "menu")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Menu {
    @Id
    private String date;

    private String breakfast;

    private String lunch;

    private String dinner;

    private String localDate;

    @Builder
    public Menu(String date, String breakfast, String lunch, String dinner, String localDate) {
        this.date = date;
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
        this.localDate = localDate;
    }
}
