package com.v2.daechelinguide.domain.lunch.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "review_lunch")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LunchReview {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double star;

    private String message;

    @ManyToOne
    @JsonProperty("menu")
    private Lunch lunch;

    public void injectLunch(Lunch lunch) {
        this.lunch = lunch;
    }

    @Builder
    public LunchReview(double star, String message) {
        this.star = star;
        this.message = message;
    }
}
