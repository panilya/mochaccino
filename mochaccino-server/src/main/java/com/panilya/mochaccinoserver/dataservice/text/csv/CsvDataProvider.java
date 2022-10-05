package com.panilya.mochaccinoserver.dataservice.text.csv;

import net.datafaker.Faker;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public enum CsvDataProvider {
    // Name
    FULL_NAME("fullName", () -> "full_name", faker -> () -> faker.name().fullName()),
    FIRST_NAME("firstName", () -> "first_name", faker -> () -> faker.name().firstName()),
    LAST_NAME("lastName", () -> "last_name", faker -> () -> faker.name().lastName()),

    // Address
    ADDRESS("address", () -> "address", faker -> () -> faker.address().fullAddress()),
    COUNTRY("country", () -> "country", faker -> () -> faker.address().country()),
    CITY("city", () -> "city", faker -> () -> faker.address().city()),
    STREET_ADDRESS("streetAddress", () -> "street_address", faker -> () -> faker.address().streetAddress()),
    ZIP_CODE("zipCode", () -> "zip_code", faker -> () -> faker.address().zipCode()),
    TIME_ZONE("timeZone", () -> "time_zone", faker -> () -> faker.address().timeZone()),

    // Credit card
    CREDIT_CARD_NUMBER("creditCardNumber", () -> "credit_card_number", faker -> () -> faker.business().creditCardNumber()),
    CREDIT_CARD_TYPE("creditCardType", () -> "credit_card_type", faker -> () -> faker.business().creditCardType()),
    CREDIT_CARD_EXPIRE("creditCardExpire", () -> "credit_card_expire", faker -> () -> faker.business().creditCardExpiry()),

    // Commerce
    COMMERCE_DEPARTMENT("commerceDepartment", () -> "commerce_department", faker -> () -> faker.commerce().department()),
    COMMERCE_VENDOR("commerceVendor", () -> "commerce_vendor", faker -> () -> faker.commerce().vendor()),
    COMMERCE_PRODUCT_NAME("productName", () -> "product_name", faker -> () -> faker.commerce().productName()),
    COMMERCE_BRAND("commerceBrand", () -> "brand", faker -> () -> faker.commerce().brand()),
    COMMERCE_MATERIAL("commerceMaterial", () -> "material", faker -> () -> faker.commerce().material()),

    // Internet
    INTERNET_EMAIL_ADDRESS("email", () -> "email", faker -> () -> faker.internet().emailAddress()),
    INTERNET_DOMAIN_NAME("domainName", () -> "domain_name", faker -> () -> faker.internet().domainName()),
    INTERNET_DOMAIN_SUFFIX("domainSuffix", () -> "domain_suffix", faker -> () -> faker.internet().domainSuffix()),
    INTERNET_URL("url", () -> "url", faker -> () -> faker.internet().url()),
    INTERNET_PASSWORD("password", () -> "password", faker -> () -> faker.internet().password()),
    INTERNET_MAC_ADDRESS("macAddress", () -> "mac_address", faker -> () -> faker.internet().macAddress()),
    INTERNET_PUBLIC_IP_V4_ADDRESS("publicIpV4Address", () -> "public_ip_v4_address", faker -> () -> faker.internet().publicIpV4Address()),
    INTERNET_PRIVATE_IP_V4_ADDRESS("privateIpV4Address", () -> "private_ip_v4_address", faker -> () -> faker.internet().privateIpV4Address()),
    INTERNET_IP_V6_ADDRESS("ipV6Address", () -> "ip_v6_address", faker -> () -> faker.internet().ipV6Address()),
    INTERNET_UUID_V3("uuidv3", () -> "uuidv3", faker -> () -> faker.internet().uuidv3()),
    INTERNET_UUID("uuid", () -> "uuid", faker -> () -> faker.internet().uuid()),
    INTERNET_USERAGENT("userAgent", () -> "user_agent", faker -> () -> faker.internet().userAgentAny()),

    // Phone Number
    PHONE_NUMBER("phoneNumber", () -> "phone_number", faker -> () -> faker.phoneNumber().phoneNumber()),
    CELL_PHONE("cellPhone", () -> "cell_phone", faker -> () -> faker.phoneNumber().cellPhone());

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
