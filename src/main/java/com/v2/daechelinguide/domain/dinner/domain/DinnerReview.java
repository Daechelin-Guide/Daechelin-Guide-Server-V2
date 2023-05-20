package com.v2.daechelinguide.domain.dinner.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "review_dinner")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DinnerReview {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double star;

    private String message;

    @ManyToOne
    @JsonProperty("menu")
    private Dinner dinner;

    public void injectDinner(Dinner dinner) {
        this.dinner = dinner;
    }

    @Builder
    public DinnerReview(double star, String message) {
        this.star = star;
        this.message = message;
    }
}
