package com.v2.daechelinguide.domain.menu.service;

import com.v2.daechelinguide.domain.breakfast.domain.Breakfast;
import com.v2.daechelinguide.domain.breakfast.domain.repository.BreakfastRepository;
import com.v2.daechelinguide.domain.dinner.domain.Dinner;
import com.v2.daechelinguide.domain.dinner.domain.repository.DinnerRepository;
import com.v2.daechelinguide.domain.lunch.domain.Lunch;
import com.v2.daechelinguide.domain.lunch.domain.repository.LunchRepository;
import com.v2.daechelinguide.domain.menu.presentation.dto.response.MenuResponse;
import com.v2.daechelinguide.global.config.WebClientConfig;
import com.v2.daechelinguide.global.properties.AddressProperties;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final AddressProperties addressProperties;
    private final BreakfastRepository breakfastRepository;
    private final LunchRepository lunchRepository;
    private final DinnerRepository dinnerRepository;
    private final WebClientConfig webClientConfig;

    @Transactional(readOnly = true)
    public MenuResponse getMeal(String year, String month, String day) {
        String date = year.concat(month.concat(day));
        String localDate = LocalDate.of(Integer.parseInt(year),
                Integer.parseInt(month),
                Integer.parseInt(day)).format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 (E)").withLocale(Locale.forLanguageTag("ko")));

        Breakfast breakfast = breakfastRepository.findBreakfastByDate(date);
        Lunch lunch = lunchRepository.findLunchByDate(date);
        Dinner dinner = dinnerRepository.findDinnerByDate(date);

        try {
            String breakfastMeal = breakfast.getMeal();
            String lunchMeal = lunch.getMeal();
            String dinnerMeal = dinner.getMeal();

            return new MenuResponse(localDate,
                    date,
                    breakfastMeal,
                    lunchMeal,
                    dinnerMeal
            );
        }catch (NullPointerException e) {
            return getMenu(date, localDate);
        }
    }

    @Transactional(readOnly = true)
    public MenuResponse getMenu(String date, String localDate) {
        String get = webClientConfig.getLunch()
                .get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("Key", addressProperties.getApiKey())
                        .queryParam("Type", "json")
                        .queryParam("ATPT_OFCDC_SC_CODE", "D10")
                        .queryParam("SD_SCHUL_CODE", "7240454")
                        .queryParam("MLSV_YMD", date)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();
        try {
            JSONParser parser = new JSONParser();
            JSONObject object = (JSONObject) parser.parse(get);

            JSONArray array = (JSONArray) object.get("mealServiceDietInfo");

            object = (JSONObject) array.get(1);
            JSONArray row = (JSONArray) object.get("row");

            String breakfast = null;
            String lunch = null;
            String dinner = null;

            for (Object value : row) {
                JSONObject mealJson = (JSONObject) value;
                String mealName = (String) mealJson.get("MMEAL_SC_NM");
                String meal = menuReplace((String) mealJson.get("DDISH_NM"));

                switch (mealName) {
                    case "조식" -> breakfast = meal;
                    case "중식" -> lunch = meal;
                    case "석식" -> dinner = meal;
                }
            }

            breakfastRepository.save(Breakfast.builder()
                            .meal(breakfast)
                            .date(date)
                            .mealDate(localDate)
                            .build());
            lunchRepository.save(Lunch.builder()
                            .meal(lunch)
                            .date(date)
                            .mealDate(localDate)
                            .build());
            dinnerRepository.save(Dinner.builder()
                            .meal(dinner)
                            .date(date)
                            .mealDate(localDate)
                            .build());

            return new MenuResponse(localDate,
                    date,
                    breakfast,
                    lunch,
                    dinner);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (NullPointerException e) {
            return new MenuResponse(localDate,
                    date,
                    null,
                    null,
                    null
                    );
        }
    }

    public String menuReplace(String menu) {
        return menu.replaceAll("\\([^)]*\\)|<br/>", "")
                .trim().replaceAll("\\s{2,}", ", ")
                .replace("1", "");
    }
}
