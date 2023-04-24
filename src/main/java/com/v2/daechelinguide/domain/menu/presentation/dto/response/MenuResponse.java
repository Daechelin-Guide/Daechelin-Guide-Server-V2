package com.v2.daechelinguide.domain.menu.presentation.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MenuResponse {
    private String date;
    private String localDate;
    private String breakfast;
    private String lunch;
    private String dinner;
}
