package com.panilya.mochaccinoserver.controller;

import com.panilya.mochaccinoserver.model.RequestEntity;
import com.panilya.mochaccinoserver.model.ResponseEntity;
import com.panilya.mochaccinoserver.service.DataGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class DataGenerationController {

    private final DataGenerationService dataGenerationService;

    @Autowired
    public DataGenerationController(DataGenerationService dataGenerationService) {
        this.dataGenerationService = dataGenerationService;
    }

    @PostMapping("/data")
    public org.springframework.http.ResponseEntity<String> generateMockData(@RequestBody RequestEntity requestEntity) {
        return org.springframework.http.ResponseEntity.ok(dataGenerationService.generateData(requestEntity));
    }
}
