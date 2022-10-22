package com.panilya.mochaccinoserver.dataservice.file.csv;

import com.panilya.mochaccinoserver.dataservice.text.formatservices.BaseDataProvider;
import com.panilya.mochaccinoserver.model.RequestEntity;
import com.panilya.mochaccinoserver.dataservice.ProviderService;
import com.panilya.mochaccinoserver.dataservice.file.FileProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class CsvAsFileDataProviderService implements FileProviderService {

    private final BaseDataProvider providerService;

    @Autowired
    public CsvAsFileDataProviderService(@Qualifier("csvFormatProviderService") BaseDataProvider providerService) {
        this.providerService = providerService;
    }

    @Override
    public byte[] getDataAsFile(RequestEntity requestEntity) {
        String providedData = providerService.generateData(requestEntity);
        byte[] providedDataBytes = providedData.getBytes(StandardCharsets.UTF_8);

        return providedDataBytes;
    }
}
