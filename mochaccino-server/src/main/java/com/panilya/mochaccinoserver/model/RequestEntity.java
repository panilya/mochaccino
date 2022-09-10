package com.panilya.mochaccinoserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class RequestEntity {

    @JsonProperty("providers")
    private final List<String> providers;
    @JsonProperty("format")
    private final String format;
    public RequestEntity(List<String> providers, String format) {
        this.providers = providers;
        this.format = format;
    }
}
