package com.panilya.mochaccinoserver.model;

import io.swagger.annotations.ApiModelProperty;

public class ProviderInfo {

    @ApiModelProperty(name = "Name of the provider", position = 1)
    private final String provider;
    @ApiModelProperty(name = "Example output of the provider", position = 2)
    private final String example;

    public ProviderInfo(String provider, String example) {
        this.provider = provider;
        this.example = example;
    }

    public String getProvider() {
        return provider;
    }

    public String getExample() {
        return example;
    }
}
