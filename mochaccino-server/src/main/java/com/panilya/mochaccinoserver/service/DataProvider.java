package com.panilya.mochaccinoserver.service;

import net.datafaker.Faker;

import java.util.function.Function;
import java.util.function.Supplier;

public enum DataProvider {
    FIRST_NAME(() -> "first_name", faker -> () -> faker.name().firstName()),
    LAST_NAME(() -> "last_name", faker -> () -> faker.name().lastName());

    private final Supplier<String> header;
    private final Function<Faker, Supplier<String>> provider;

    DataProvider(Supplier<String> header, Function<Faker, Supplier<String>> provider) {
        this.header = header;
        this.provider = provider;
    }

    public Supplier<String> getHeader() {
        return header;
    }

    public Function<Faker, Supplier<String>> getProvider() {
        return provider;
    }
}
