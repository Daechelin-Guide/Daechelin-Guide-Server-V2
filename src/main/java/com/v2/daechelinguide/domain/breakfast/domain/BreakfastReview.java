package com.v2.daechelinguide.domain.breakfast.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "review_breakfast")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BreakfastReview {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double star;

    private String message;

    @ManyToOne
    @JoinColumn(name = "breakfast_date")
    private Breakfast breakfast;

    public void injectBreakfast(Breakfast breakfast) {
        this.breakfast = breakfast;
    }

    @Builder
    public BreakfastReview(double star, String message) {
        this.star = star;
        this.message = message;
    }
}