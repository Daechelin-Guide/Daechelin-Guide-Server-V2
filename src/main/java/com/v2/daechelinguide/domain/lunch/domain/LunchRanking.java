package com.v2.daechelinguide.domain.lunch.domain;

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
public class LunchRanking {

    @Id
    private String date;

    private double star;

    @ManyToOne
    @JsonProperty("menu")
    private Lunch lunch;

    public void injectLunch(Lunch lunch) {
        this.lunch = lunch;
    }

    @Builder
    public LunchRanking(String date, double star) {
        this.date = date;
        this.star = star;
    }
}
