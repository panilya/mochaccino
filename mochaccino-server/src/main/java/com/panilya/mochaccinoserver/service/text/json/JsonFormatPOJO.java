package com.panilya.mochaccinoserver.service.text.json;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import net.datafaker.*;

@ToString
@Getter
@Builder
public class JsonFormatPOJO {

    private final Name name;
    private final Address address;
    private final Business business;
    private final Commerce commerce;
    private final Faker faker;

    public JsonFormatPOJO(Name name, Address address, Business business, Commerce commerce, Faker faker) {
        this.name = name;
        this.address = address;
        this.business = business;
        this.commerce = commerce;
        this.faker = faker;
    }
}
