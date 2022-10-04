package com.panilya.mochaccinoserver.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.panilya.mochaccinoserver.infoservice.InfoService;
import com.panilya.mochaccinoserver.model.GroupInfoEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
public class MetadataProviderController {

    @GetMapping(value = "/info/groups")
    public ResponseEntity<String> providerGroups() {

        Set<GroupInfoEntity> providerGroupInfos = Arrays.stream(InfoService.ProviderGroupInfo.values())
                .map(InfoService.ProviderGroupInfo::getGroupInfo)
                .collect(Collectors.toSet());

        ObjectMapper mapper = new ObjectMapper();
        String jsonAsString = "";
        try {
            jsonAsString = mapper.writeValueAsString(providerGroupInfos);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error");
        }

        return ResponseEntity.ok(jsonAsString);
    }

}
