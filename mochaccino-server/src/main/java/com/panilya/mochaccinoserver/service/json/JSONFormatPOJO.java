package com.panilya.mochaccinoserver.service.json;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import net.datafaker.Address;
import net.datafaker.Faker;
import net.datafaker.Name;

@ToString
@Getter
@Builder
public class JsonFormatPOJO {

    private final Name name;
    private final Address address;
    private final Faker faker;

    public JsonFormatPOJO(Name name, Address address, Faker faker) {
        this.name = name;
        this.address = address;
        this.faker = faker;
    }
}
