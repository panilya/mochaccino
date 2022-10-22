package com.panilya.mochaccinoserver.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class GroupInfoEntity {

    @ApiModelProperty(name = "List of providers of the group", position = 1)
    private final List<ProviderInfo> providers;
    @ApiModelProperty(name = "Name of the group", position = 2)
    private final String name;
    @ApiModelProperty(name = "Description of the group")
    private final String description;
    @ApiModelProperty(name = "ID of the group")
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
