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
    @JsonProperty("limit")
    private final int limit;
    @JsonProperty("separator")
    private final String separator;
    @JsonProperty("header")
    private final boolean header;

    public RequestEntity(List<String> providers, String format, int limit, String separator, boolean header) {
        this.providers = providers;
        this.format = format;
        this.limit = limit;
        this.separator = separator;
        this.header = header;
    }
}
