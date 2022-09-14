package com.panilya.mochaccinoserver.service.csv;

import net.datafaker.Faker;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public enum DataProvider {
    FIRST_NAME("firstName", () -> "first_name", faker -> () -> faker.name().firstName()),
    LAST_NAME("lastName", () -> "last_name", faker -> () -> faker.name().lastName()),
    ADDRESS("address", () -> "address", faker -> () -> faker.address().fullAddress()),
    COUNTRY("country", () -> "country", faker -> () -> faker.address().country()),
    CITY("city", () -> "city", faker -> () -> faker.address().city()),
    ZIP_CODE("zipCode", () -> "zip_code", faker -> () -> faker.address().zipCode());

    private final String name;
    private final Supplier<String> header;
    private final Function<Faker, Supplier<String>> provider;

    DataProvider(String name, Supplier<String> header, Function<Faker, Supplier<String>> provider) {
        this.name = name;
        this.header = header;
        this.provider = provider;
    }

    private static final Map<String, DataProvider> CSV_PROVIDER_MAP = Collections.unmodifiableMap(
            Arrays.stream(values()).collect(Collectors.toMap(t -> t.name, Function.identity())));

    public static DataProvider of(String name) {
        return CSV_PROVIDER_MAP.get(name);
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
