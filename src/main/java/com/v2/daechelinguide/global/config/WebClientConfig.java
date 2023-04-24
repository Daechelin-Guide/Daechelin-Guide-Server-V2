package com.v2.daechelinguide.global.config;

import com.v2.daechelinguide.global.properties.AddressProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
public class WebClientConfig implements WebFluxConfigurer {

    private final AddressProperties addressProperties;

    @Bean
    public WebClient getLunch() {
        return WebClient.builder()
                .baseUrl(addressProperties.getUrl())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}
