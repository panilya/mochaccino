package com.panilya.mochaccinoserver.config;

import net.datafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Configuration
public class MochaccinoConfiguration {

    @Bean(name = "faker")
    public Faker faker() {
        return new Faker(new Locale("en", "US"));
    }

}
