package com.panilya.mochaccinoserver.service;

import net.datafaker.Faker;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public enum DataProvider {
    FIRST_NAME("firstName", () -> "first_name", faker -> () -> faker.name().firstName()),
    LAST_NAME("lastName", () -> "last_name", faker -> () -> faker.name().lastName());

    private final String name;
    private final Supplier<String> header;
    private final Function<Faker, Supplier<String>> provider;

    DataProvider(String name, Supplier<String> header, Function<Faker, Supplier<String>> provider) {
        this.name = name;
        this.header = header;
        this.provider = provider;
    }

    private static final Map<String, DataProvider> PROVIDER_MAP = Collections.unmodifiableMap(
            Arrays.stream(values()).collect(Collectors.toMap(t -> t.name, Function.identity())));

    public static DataProvider of(String name) {
        return PROVIDER_MAP.get(name);
    }

    public String getName() {
        return name;
    }

    public Supplier<String> getHeader() {
        return header;
    }

    public Function<Faker, Supplier<String>> getProvider() {
        return provider;
    }
}
