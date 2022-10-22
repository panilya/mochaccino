package com.panilya.mochaccinoserver.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.beans.ConstructorProperties;
import java.util.List;

@Getter
@ToString
public class RequestEntity {

    @JsonProperty("providers")
    private final List<String> providers;
    @JsonProperty("limit")
    private final int limit;

    @JsonCreator
    @ConstructorProperties({"providers", "limit"})
    public RequestEntity(List<String> providers, int limit) {
        this.providers = providers;
        this.limit = limit;
    }
}
