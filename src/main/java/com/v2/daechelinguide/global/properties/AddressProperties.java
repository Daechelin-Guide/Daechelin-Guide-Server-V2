package com.v2.daechelinguide.global.properties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;


@Getter
@Component
@Validated
@ConfigurationProperties(prefix = "address")
public class AddressProperties {
    private String lunch;
}
