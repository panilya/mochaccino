package com.panilya.mochaccinoserver.model;

public class ProviderInfo {

    private final String provider;
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
