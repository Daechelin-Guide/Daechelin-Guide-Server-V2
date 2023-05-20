package com.v2.daechelinguide.domain.breakfast.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BreakfastRanking {

    @Id
    private String date;

    private double star;

    @ManyToOne
    @JsonProperty("menu")
    private Breakfast breakfast;

    public void injectBreakfast(Breakfast breakfast) {
        this.breakfast = breakfast;
    }

    @Builder
    public BreakfastRanking(String date, double star) {
        this.date = date;
        this.star = star;
    }
}
