package com.v2.daechelinguide.global.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Data
@Configuration
@ConfigurationProperties(prefix = "menu")
public class AddressProperties {
    private String url;
    private String apiKey;
}
