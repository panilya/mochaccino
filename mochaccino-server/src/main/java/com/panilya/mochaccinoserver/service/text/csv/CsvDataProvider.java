package com.panilya.mochaccinoserver.service.text.csv;

import net.datafaker.Faker;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public enum CsvDataProvider {
    FIRST_NAME("firstName", () -> "first_name", faker -> () -> faker.name().firstName()),
    LAST_NAME("lastName", () -> "last_name", faker -> () -> faker.name().lastName()),
    ADDRESS("address", () -> "address", faker -> () -> faker.address().fullAddress()),
    COUNTRY("country", () -> "country", faker -> () -> faker.address().country()),
    CITY("city", () -> "city", faker -> () -> faker.address().city()),
    STREET_ADDRESS("streetAddress", () -> "street_address", faker -> () -> faker.address().streetAddress()),
    ZIP_CODE("zipCode", () -> "zip_code", faker -> () -> faker.address().zipCode());

    private final String name;
    private final Supplier<String> header;
    private final Function<Faker, Supplier<String>> provider;

    CsvDataProvider(String name, Supplier<String> header, Function<Faker, Supplier<String>> provider) {
        this.name = name;
        this.header = header;
        this.provider = provider;
    }

    private static final Map<String, CsvDataProvider> CSV_PROVIDER_MAP = Collections.unmodifiableMap(
            Arrays.stream(values()).collect(Collectors.toMap(t -> t.name, Function.identity())));

    public static CsvDataProvider of(String name) {
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
