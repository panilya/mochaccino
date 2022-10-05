package com.panilya.mochaccinoserver.dataservice.text.json;

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
    private final Internet internet;
    private final PhoneNumber phoneNumber;
    private final Faker faker;

    public JsonFormatPOJO(Name name, Address address, Business business, Commerce commerce, Internet internet, PhoneNumber phoneNumber, Faker faker) {
        this.name = name;
        this.address = address;
        this.business = business;
        this.commerce = commerce;
        this.internet = internet;
        this.phoneNumber = phoneNumber;
        this.faker = faker;
    }
}
