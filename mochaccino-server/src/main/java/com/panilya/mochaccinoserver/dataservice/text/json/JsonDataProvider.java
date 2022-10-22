package com.panilya.mochaccinoserver.dataservice.text.json;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum JsonDataProvider {
    // Name
    FULL_NAME("fullName", jsonProvider -> jsonProvider.getName().fullName()),
    FIRST_NAME("firstName", jsonProvider -> jsonProvider.getName().firstName()),
    LAST_NAME("lastName", jsonProvider -> jsonProvider.getName().lastName()),

    // Address
    ADDRESS("address", jsonProvider -> jsonProvider.getAddress().fullAddress()),
    COUNTRY("country", jsonProvider -> jsonProvider.getAddress().country()),
    CITY("city", jsonProvider -> jsonProvider.getAddress().city()),
    STREET_ADDRESS("streetAddress", jsonProvider -> jsonProvider.getAddress().streetAddress()),
    ZIP_CODE("zipCode", jsonProvider -> jsonProvider.getAddress().zipCode()),
    TIME_ZONE("timeZone", jsonProvider -> jsonProvider.getAddress().timeZone()),

    // Credit card
    CREDIT_CARD_NUMBER("creditCardNumber", jsonProvider -> jsonProvider.getBusiness().creditCardNumber()),
    CREDIT_CARD_TYPE("creditCardType", jsonProvider -> jsonProvider.getBusiness().creditCardType()),
    CREDIT_CARD_EXPIRE("creditCardExpire", jsonProvider -> jsonProvider.getBusiness().creditCardExpiry()),

    // Commerce
    COMMERCE_DEPARTMENT("commerceDepartment", jsonProvider -> jsonProvider.getCommerce().department()),
    COMMERCE_VENDOR("commerceVendor", jsonProvider -> jsonProvider.getCommerce().vendor()),
    COMMERCE_PRODUCT_NAME("productName", jsonProvider -> jsonProvider.getCommerce().productName()),
    COMMERCE_BRAND("commerceBrand", jsonProvider -> jsonProvider.getCommerce().brand()),
    COMMERCE_MATERIAL("commerceMaterial", jsonProvider -> jsonProvider.getCommerce().material()),

    // Internet
    INTERNET_EMAIL_ADDRESS("email", jsonProvider -> jsonProvider.getInternet().emailAddress()),
    INTERNET_DOMAIN_NAME("domainName", jsonProvider -> jsonProvider.getInternet().domainName()),
    INTERNET_DOMAIN_SUFFIX("domainSuffix", jsonProvider -> jsonProvider.getInternet().domainSuffix()),
    INTERNET_URL("url", jsonProvider -> jsonProvider.getInternet().url()),
    INTERNET_PASSWORD("password", jsonProvider -> jsonProvider.getInternet().password()),
    INTERNET_MAC_ADDRESS("macAddress", jsonProvider -> jsonProvider.getInternet().macAddress()),
    INTERNET_PUBLIC_IP_V4_ADDRESS("publicIpV4Address", jsonProvider -> jsonProvider.getInternet().publicIpV4Address()),
    INTERNET_PRIVATE_IP_V4_ADDRESS("privateIpV4Address", jsonProvider -> jsonProvider.getInternet().privateIpV4Address()),
    INTERNET_IP_V6_ADDRESS("ipV6Address", jsonProvider -> jsonProvider.getInternet().ipV6Address()),
    INTERNET_UUID_V3("uuidv3", jsonProvider -> jsonProvider.getInternet().uuidv3()),
    INTERNET_UUID("uuid", jsonProvider -> jsonProvider.getInternet().uuid()),

    // Phone Number
    PHONE_NUMBER("phoneNumber", jsonProvider -> jsonProvider.getPhoneNumber().phoneNumber()),
    CELL_PHONE("cellPhone", jsonProvider -> jsonProvider.getPhoneNumber().cellPhone());

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
