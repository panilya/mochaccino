package com.panilya.mochaccinoserver.service;

import com.panilya.mochaccinoserver.model.RequestEntity;
import com.panilya.mochaccinoserver.model.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataGenerationService {

    private final DataProviderService dataProviderService;

    @Autowired
    public DataGenerationService(DataProviderService dataProviderService) {
        this.dataProviderService = dataProviderService;
    }

    public ResponseEntity generateData(RequestEntity requestEntity) {
        //TODO: complete this method
        return null;
    }
}
