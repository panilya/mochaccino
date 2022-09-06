package com.panilya.mochaccinoserver;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class ResponseDto {

    private final String id;
    private final String fullName;
    private final String firstName;
    private final String lastName;
    private final String phoneNumber;
    private final String address;

}
