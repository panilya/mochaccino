package com.panilya.mochaccinoserver.service.text.json;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum JsonDataProvider {
    FULL_NAME("fullName", jsonProvider -> jsonProvider.getName().fullName()),
    FIRST_NAME("firstName", jsonProvider -> jsonProvider.getName().firstName()),
    LAST_NAME("lastName", jsonProvider -> jsonProvider.getName().lastName()),
    ADDRESS("address", jsonProvider -> jsonProvider.getAddress().fullAddress()),
    COUNTRY("country", jsonProvider -> jsonProvider.getAddress().country()),
    CITY("city", jsonProvider -> jsonProvider.getAddress().city()),
    STREET_ADDRESS("streetAddress", jsonProvider -> jsonProvider.getAddress().streetAddress()),
    ZIP_CODE("zipCode", jsonProvider -> jsonProvider.getAddress().zipCode()),
    TIME_ZONE("timeZone", jsonProvider -> jsonProvider.getAddress().timeZone()),
    CREDIT_CARD_NUMBER("creditCardNumber", jsonProvider -> jsonProvider.getBusiness().creditCardNumber()),
    CREDIT_CARD_TYPE("creditCardType", jsonProvider -> jsonProvider.getBusiness().creditCardType()),
    CREDIT_CARD_EXPIRE("creditCardExpire", jsonProvider -> jsonProvider.getBusiness().creditCardExpiry());

    private final String name;
    private final Function<JsonFormatPOJO, Object> provider;

    JsonDataProvider(String name, Function<JsonFormatPOJO, Object> provider) {
        this.name = name;
        this.provider = provider;
    }

    private static final Map<String, JsonDataProvider> JSON_PROVIDER_MAP = Collections.unmodifiableMap(
            Arrays.stream(values()).collect(Collectors.toMap(t -> t.name, Function.identity())));

    public static JsonDataProvider of(String name) {
        return JSON_PROVIDER_MAP.get(name);
    }

    public String getName() {
        return name;
    }

    public Function<JsonFormatPOJO, Object> getProvider() {
        return provider;
    }
}
