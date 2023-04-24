package com.v2.daechelinguide.global.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .title("대슐랭가이드")
                .version("v2.0.0")
                .description("대슐랭가이드 API 문서");

        return new OpenAPI()
                .components(new Components())
                .info(info);
    }
}