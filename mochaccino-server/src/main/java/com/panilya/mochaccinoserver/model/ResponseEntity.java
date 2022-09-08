package com.panilya.mochaccinoserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResponseEntity {

    @JsonProperty("fullName")
    private final String fullName;
    @JsonProperty("firstName")
    private final String firstName;
    @JsonProperty("lastName")
    private final String lastName;
    @JsonProperty("phoneNumber")
    private final String phoneNumber;
    @JsonProperty("address")
    private final String address;


}
