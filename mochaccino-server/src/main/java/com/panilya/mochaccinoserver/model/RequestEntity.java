package com.panilya.mochaccinoserver.model;

public class RequestEntity {

    private final boolean id;
    private final boolean fullName;
    private final boolean firstName;
    private final boolean lastName;
    private final boolean phoneNumber;
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
}
