package com.panilya.mochaccinoserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestEntity {

    @JsonProperty("id")
    private final boolean id;
    @JsonProperty("fullName")
    private final boolean fullName;
    @JsonProperty("firstName")
    private final boolean firstName;
    @JsonProperty("lastName")
    private final boolean lastName;
    @JsonProperty("phoneNumber")
    private final boolean phoneNumber;
    @JsonProperty("address")
    private final boolean address;

    //TODO: I guess there is a better way to implement this
    public RequestEntity(boolean fullName, boolean phoneNumber, boolean id, boolean firstName, boolean lastName, boolean address) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }
    
    @Override
    public String toString() {
        return "RequestEntity{" +
                "id=" + id +
                ", fullName=" + fullName +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", phoneNumber=" + phoneNumber +
                ", address=" + address +
                '}';
    }
}
