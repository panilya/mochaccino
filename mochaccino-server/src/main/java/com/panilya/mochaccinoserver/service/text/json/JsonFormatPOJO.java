package com.panilya.mochaccinoserver.service.text.json;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import net.datafaker.Address;
import net.datafaker.Business;
import net.datafaker.Faker;
import net.datafaker.Name;

@ToString
@Getter
@Builder
public class JsonFormatPOJO {

    private final Name name;
    private final Address address;
    private final Business business;
    private final Faker faker;

    public JsonFormatPOJO(Name name, Address address, Business business, Faker faker) {
        this.name = name;
        this.address = address;
        this.business = business;
        this.faker = faker;
    }
}
