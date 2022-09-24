package com.panilya.mochaccinoserver.service.text;

import com.panilya.mochaccinoserver.model.RequestEntity;
import com.panilya.mochaccinoserver.service.DataFormat;
import com.panilya.mochaccinoserver.service.ProviderService;
import com.panilya.mochaccinoserver.utils.RequestEntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DataGenerationService {

    private final FormatProviderServiceFactory providerServiceFactory;

    /**
     * By default, use csv format generation
     *
     * @param providerServiceFactory
     */
    @Autowired
    public DataGenerationService(FormatProviderServiceFactory providerServiceFactory) {
        this.providerServiceFactory = providerServiceFactory;
    }

    public String generateData(RequestEntity requestEntity, String requestParamFormat) {

        DataFormat format;
        try {
            format = RequestEntityUtils.readFormatParam(requestParamFormat);
        } catch (NoSuchFieldException e) {
            throw new NoSuchElementException("Format is not specified");
        }

        ProviderService providerService = providerServiceFactory.createProviderService(format);
        return providerService.provideData(requestEntity);
    }
}
