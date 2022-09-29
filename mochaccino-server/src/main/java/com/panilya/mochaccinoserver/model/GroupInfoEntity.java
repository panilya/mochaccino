package com.panilya.mochaccinoserver.model;

import java.util.List;

public class GroupInfoEntity {

    private final List<ProviderInfo> providers;
    private final String name;
    private final String description;
    private final Long id;

    public GroupInfoEntity(List<ProviderInfo> providers, String name, String description, Long id) {
        this.providers = providers;
        this.name = name;
        this.description = description;
        this.id = id;
    }

    public List<ProviderInfo> getProviders() {
        return providers;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Long getId() {
        return id;
    }
}
