package com.panilya.mochaccinoserver.config;

import net.datafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MochaccinoConfiguration {

    @Bean
    public Faker faker() {
        return new Faker();
    }
}
