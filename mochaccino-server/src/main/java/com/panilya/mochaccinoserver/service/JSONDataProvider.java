package com.panilya.mochaccinoserver.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum JSONDataProvider {
    FIRST_NAME("firstName", jsonProvider -> jsonProvider.getName().firstName()),
    LAST_NAME("lastName", jsonProvider -> jsonProvider.getName().lastName()),
    ADDRESS("address", jsonProvider -> jsonProvider.getAddress().fullAddress());

    private final String name;
    private final Function<JSONFormatPOJO, Object> provider;

    JSONDataProvider(String name, Function<JSONFormatPOJO, Object> provider) {
        this.name = name;
        this.provider = provider;
    }

    private static final Map<String, JSONDataProvider> JSON_PROVIDER_MAP = Collections.unmodifiableMap(
            Arrays.stream(values()).collect(Collectors.toMap(t -> t.name, Function.identity())));

    public static JSONDataProvider of(String name) {
        return JSON_PROVIDER_MAP.get(name);
    }

    public String getName() {
        return name;
    }

    public Function<JSONFormatPOJO, Object> getProvider() {
        return provider;
    }
}
