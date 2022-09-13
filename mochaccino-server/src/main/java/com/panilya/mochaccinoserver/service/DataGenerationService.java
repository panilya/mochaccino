package com.panilya.mochaccinoserver.service;

import com.panilya.mochaccinoserver.model.RequestEntity;
import com.panilya.mochaccinoserver.utils.RequestEntityUtils;
import net.datafaker.fileformats.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DataGenerationService {

    private final ProviderService dataProviderService;
    private final FormatProviderServiceFactory providerServiceFactory;

    /**
     * By default, use csv format generation
     *
     * @param dataProviderService
     * @param providerServiceFactory
     */
    @Autowired
    public DataGenerationService(@Qualifier("csvFormatProviderService") ProviderService dataProviderService, FormatProviderServiceFactory providerServiceFactory) {
        this.dataProviderService = dataProviderService;
        this.providerServiceFactory = providerServiceFactory;
    }

    public String generateData(RequestEntity requestEntity) {

        DataFormat format;
        try {
            format = RequestEntityUtils.readFormatString(requestEntity);
        } catch (NoSuchFieldException e) {
            throw new NoSuchElementException("Format is not specified");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        ProviderService providerService = providerServiceFactory.createProviderService(format);
        return providerService.provideData(requestEntity);
    }
}
