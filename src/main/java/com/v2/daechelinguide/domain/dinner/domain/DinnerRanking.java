package com.v2.daechelinguide.domain.dinner.domain;

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
public class DinnerRanking {
    @Id
    private String date;

    private double star;

    @ManyToOne
    @JsonProperty("menu")
    private Dinner dinner;

    public void injectDinner(Dinner dinner) {
        this.dinner = dinner;
    }

    @Builder
    public DinnerRanking(String date, double star) {
        this.date = date;
        this.star = star;
    }
}
