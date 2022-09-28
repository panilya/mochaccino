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
    @JsonProperty("separator")
    private final String separator;
    @JsonProperty("header")
    private final boolean header;

    @JsonCreator
    @ConstructorProperties({"providers", "limit", "separator", "header"})
    public RequestEntity(List<String> providers, int limit, String separator, boolean header) {
        this.providers = providers;
        this.limit = limit;
        this.separator = separator;
        this.header = header;
    }
}
